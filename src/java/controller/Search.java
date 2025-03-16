/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.ProductDAO;
import dao.TagDao;
import entity.ProductEntity;
import entity.UserEntity;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.logging.Logger;

public class Search extends HttpServlet {
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
                    HttpSession session = request.getSession();

        try {

            String[] selectedTags = request.getParameterValues("tags");
            String searchTerm = request.getParameter("q");
            TagDao tagDAO = new TagDao();
            ProductDAO productDAO = new ProductDAO();
            List<String> allTags = tagDAO.getAllTagNames();
//            logger.severe(allTags.toString());
            List<ProductEntity> products = productDAO.searchProducts(selectedTags, searchTerm);
//            System.out.println(products);
//            logger.severe(products.toString());
            request.setAttribute("allTags", allTags);
            request.setAttribute("selectedTags", selectedTags);
            request.setAttribute("searchTerm", searchTerm);
            request.setAttribute("products", products);

//            processRequest(request, response);
//            HttpSession session = request.getSession();
//            UserEntity currentUser = (UserEntity) session.getAttribute("user");
//            if (currentUser == null) {
//                response.sendRedirect("search.jsp");
//            } else {
                request.getRequestDispatcher("search.jsp").forward(request, response);
//            }
        } catch (IllegalStateException e) {
            response.sendRedirect("index.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
    }

}
