/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.UserDao;
import entity.UserEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import utilities.PasswordEncryption;

/**
 * @author admin
 */
public class Register extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the
    // left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("register.jsp");

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        try {
            String message = "";
            HttpSession session = request.getSession();
            String email = request.getParameter("email");
            String password = request.getParameter("password1");
            String rpassword = request.getParameter("password2");
            UserDao ddao = new UserDao();
            
            if (!rpassword.equals(password) ) {
                request.setAttribute("errorMessage", "Passwords do not match!");
                request.getRequestDispatcher("register.jsp").forward(request, response);
                return;
            }

//      ArrayList<UserEntity>user = new ArrayList<>();
//      session.setAttribute("user", user);
            UserEntity checkExist = ddao.getUserByEmail(email);

            if (checkExist == null) {
                password = PasswordEncryption.encryptPassword(password);
                ddao.insertUserWithEmailPassword(email, password);
                response.sendRedirect("homePage");
            } else {
                request.setAttribute("errorMessage", "Email already registered!");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } catch (Exception e) {

            request.setAttribute("errorMessage", "Invalid input.Please Try again!" + e);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    } // </editor-fold>
}
