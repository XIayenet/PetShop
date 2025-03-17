/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.ProductDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.util.logging.Logger;
import utilities.ImageManager;

@MultipartConfig
public class AddProduct extends HttpServlet {

  private static final Logger logger = Logger.getLogger(HomePage.class.getName());

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);

    try {
      String productName = request.getParameter("productName");
      String description = request.getParameter("productDescription");
      double price = Double.parseDouble(request.getParameter("price"));
      int stockQuantity = Integer.parseInt(request.getParameter("stock"));
      
      Part imagePart = request.getPart("image");
      logger.severe(imagePart.toString());

      // Upload image to ImgBB
      String imageUrl = ImageManager.uploadImageToImgBB(imagePart);
      logger.severe(imageUrl);
      ProductDAO pdao = new ProductDAO();
      pdao.createProduct(productName, description, price, stockQuantity, imageUrl);

      // Redirect to a success page or display the image
      response.sendRedirect("productList");
    } catch (Exception e) {
      logger.severe(e.toString());
    }
  }

}
