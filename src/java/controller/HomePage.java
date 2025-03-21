/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.ProductTagDao;
import entity.ProductEntity;
import entity.UserEntity;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.logging.Logger;

public class HomePage extends HttpServlet {

    private static final Logger logger = Logger.getLogger(HomePage.class.getName());

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
//            processRequest(request, response);
            HttpSession session = request.getSession();
            ProductTagDao ptd = new ProductTagDao();
            ArrayList<ProductEntity> dogToysProducts = ptd.getProductsByTagId(4);
            ArrayList<ProductEntity> dogFoodies = ptd.getProductsByTagId(5);
            UserEntity currentUser = (UserEntity) session.getAttribute("user");
            request.setAttribute("dogToys",dogToysProducts); 
            request.setAttribute("dogFood",dogFoodies); 
            if (currentUser == null) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
        } catch (IllegalStateException e) {
            logger.severe("IllegalStateException: " + e.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String clothing = request.getParameter("clothing");
        
    }

  public static void main(String[] args) {
  
      ProductTagDao ptd = new ProductTagDao();
    System.out.println(ptd.getProductsByTagId(5));
  }
}
