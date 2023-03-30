package com.rosebloom.controllers.servlets;

import com.google.gson.Gson;
import com.rosebloom.controllers.services.CartServices;
import com.rosebloom.controllers.utils.CustomValidationMessage;
import com.rosebloom.dtos.CartDto;
import com.rosebloom.dtos.CartIdDto;
import com.rosebloom.dtos.UserDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CheckoutServlet extends HttpServlet {
    ServletConfig myConfig;

    @Override
    public void init(ServletConfig arg0) throws ServletException {
        myConfig=arg0;
        System.out.println("Init!!!!!");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String isLoggedIn = (String) session.getAttribute("loggedIn");
        if (isLoggedIn != null && isLoggedIn.equals("true")) {
            UserDto user = (UserDto) session.getAttribute("User");
            if(user.getIsAdmin()==-1){
                RequestDispatcher dispatcher = request.getRequestDispatcher("/login2.html");
                dispatcher.forward(request, response);
            }else{
                RequestDispatcher dispatcher = request.getRequestDispatcher("view/html/checkout2.jsp");
                dispatcher.forward(request, response);
            }
        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String isLoggedIn = (String) session.getAttribute("loggedIn");
        if (isLoggedIn != null && isLoggedIn.equals("true")) {
            UserDto user = (UserDto) session.getAttribute("User");
            if(user.getIsAdmin()==-1){
                RequestDispatcher dispatcher = request.getRequestDispatcher("/login2.html");
                dispatcher.forward(request, response);
            }else{
                RequestDispatcher dispatcher = request.getRequestDispatcher("view/html/checkout2.jsp");
                dispatcher.forward(request, response);
            }
        }
    }
}
