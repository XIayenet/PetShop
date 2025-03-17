/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.ProductDAO;
import entity.ProductEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.logging.Logger;
import utilities.ImageManager;

/**
 * @author admin
 */
@MultipartConfig
public class EditProduct extends HttpServlet {
  
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
  }
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }
  
  private static final Logger logger = Logger.getLogger(HomePage.class.getName());

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    
    ProductDAO pdao = new ProductDAO();

    String productID = request.getParameter("productID");
    String productName = request.getParameter("productName");
    String description = request.getParameter("productDescription");
    double price = Double.parseDouble(request.getParameter("price"));
    int stockQuantity = Integer.parseInt(request.getParameter("stock"));
    
    ProductEntity product = pdao.getProduct(Integer.parseInt(productID));
    String imageUrl = product.getImage();
    logger.severe(request.getPart("image").toString());
    Part imagePart = request.getPart("image");
    if (imagePart != null && imagePart.getSize() > 0) { // Check size to confirm file content
            logger.severe("New image uploaded: " + imagePart.getSubmittedFileName() + ", Size: " + imagePart.getSize());
            imageUrl = ImageManager.uploadImageToImgBB(imagePart); // Update image URL if new file is provided
            if (imageUrl == null) {
                throw new ServletException("Image upload to ImgBB failed");
            }
        } else {
            logger.severe("No new image uploaded; retaining existing image: " + imageUrl);
        }
    
    pdao.updateProduct(Integer.parseInt(productID), productName, description, price, imageUrl, stockQuantity);
    response.sendRedirect("productList");
  }

  @Override
  public String getServletInfo() {
    return "Short description";
  } // </editor-fold>
}
