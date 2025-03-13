/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import jakarta.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

;

/**
 *
 * @author Admin
 */
public class ImageManager {

    private static final String IMGBB_API_KEY = "168f0c782f7ffe63c9c02220083c0498";

    public String uploadImageToImgBB(Part imagePart) throws IOException {
        // Convert image to Base64
        InputStream imageStream = imagePart.getInputStream();
        byte[] imageBytes = imageStream.readAllBytes();
        String base64Image = Base64.getEncoder().encodeToString(imageBytes);

        // Prepare ImgBB API request
        String url = "https://api.imgbb.com/1/upload";
        String postData = "key=" + IMGBB_API_KEY + "&image=" + base64Image;

        // Send request to ImgBB
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.getOutputStream().write(postData.getBytes(StandardCharsets.UTF_8));

        // Parse response
        String jsonResponse = new String(connection.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        String imageUrl = parseImageUrlFromJson(jsonResponse);

        return imageUrl;
    }
    
    private String parseImageUrlFromJson(String jsonResponse) {
        // Parse the JSON response to extract the image URL
        // Example: {"data":{"url":"https://i.ibb.co/...","display_url":"https://i.ibb.co/..."},"success":true,"status":200}
        int urlStart = jsonResponse.indexOf("\"url\":\"") + 7;
        int urlEnd = jsonResponse.indexOf("\"", urlStart);
        return jsonResponse.substring(urlStart, urlEnd);
    }
}
