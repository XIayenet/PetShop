/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.ProductDAO;
import dao.TagDao;
import entity.ProductEntity;
import entity.TagEntity;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ProductDetail extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        ProductDAO pdao = new ProductDAO();
        TagDao tdao = new TagDao();
        try {
            ProductEntity product = pdao.getProduct(Integer.parseInt(request.getParameter("productID")));
            if (product == null) {
                response.sendRedirect("homePage");
            } else {
                ArrayList<TagEntity> tags = tdao.getTagByProduct(product.getProductID());
                
                request.setAttribute("product", product);
                request.setAttribute("tags", tags);
                request.getRequestDispatcher("product-detail.jsp").forward(request, response);
            }
        } catch (Exception e) {
            response.sendRedirect("homePage");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
