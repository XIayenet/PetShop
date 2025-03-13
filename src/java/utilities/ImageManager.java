/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import controller.HomePage;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.Scanner;
import java.util.logging.Logger;

;

/**
 *
 * @author Admin
 */
public class ImageManager {

    private static final String IMGBB_API_KEY = "168f0c782f7ffe63c9c02220083c0498";
    private static final Logger logger = Logger.getLogger(HomePage.class.getName());

    public static String uploadImageToImgBB(Part imagePart) throws IOException {
        // Convert image to Base64
        InputStream imageStream = imagePart.getInputStream();
        byte[] imageBytes = imageStream.readAllBytes();
        String base64Image = Base64.getEncoder().encodeToString(imageBytes);

        String url = "https://api.imgbb.com/1/upload";
        String boundary = "----WebKitFormBoundary7MA4YWxkTrZu0gW"; // Random boundary string
        String postData = "--" + boundary + "\r\n"
                + "Content-Disposition: form-data; name=\"key\"\r\n\r\n"
                + IMGBB_API_KEY + "\r\n"
                + "--" + boundary + "\r\n"
                + "Content-Disposition: form-data; name=\"image\"\r\n\r\n"
                + base64Image + "\r\n"
                + "--" + boundary + "--\r\n";

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

        // Write the form-data body
        try (OutputStream os = connection.getOutputStream()) {
            os.write(postData.getBytes());
        }

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            Scanner scanner = new Scanner(connection.getInputStream()).useDelimiter("\\A");
            String response = scanner.hasNext() ? scanner.next() : "";

            // Parse JSON response to get image URL
            String imageUrl = response.split("\"url\":\"")[1].split("\"")[0];
            return imageUrl;
        } else {
            System.err.println("ImgBB API Error: " + responseCode);
            return null; // Upload failed
        }
    }

    private static String parseImageUrlFromJson(String jsonResponse) {
        // Parse the JSON response to extract the image URL
        // Example: {"data":{"url":"https://i.ibb.co/...","display_url":"https://i.ibb.co/..."},"success":true,"status":200}
        int urlStart = jsonResponse.indexOf("\"url\":\"") + 7;
        int urlEnd = jsonResponse.indexOf("\"", urlStart);
        return jsonResponse.substring(urlStart, urlEnd);
    }
}
