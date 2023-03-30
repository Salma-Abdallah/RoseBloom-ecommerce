package com.rosebloom.controllers.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.http.*;

import jakarta.servlet.ServletException;

public class logoutServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession();
        session.removeAttribute("loggedIn");
        session.removeAttribute("User");
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0);  // Set the cookie's expiration date to a time in the past
                response.addCookie(cookie);  // Add the cookie to the response
            }
        }
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }
}
