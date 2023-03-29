package com.rosebloom.controllers.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class HomeServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        RequestDispatcher rd = request.getRequestDispatcher("/");
        rd.forward(request, response);

    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("\n\n\n\nPOST");
        HttpSession session = request.getSession(true);
        RequestDispatcher rd = request.getRequestDispatcher("/");
        rd.forward(request, response);

    }

}
