package com.rosebloom.controllers.servlets;

import com.google.gson.Gson;
import com.rosebloom.controllers.enums.OrderStatus;
import com.rosebloom.controllers.services.CartServices;
import com.rosebloom.controllers.services.OrderServices;
import com.rosebloom.controllers.utils.CustomValidationMessage;
import com.rosebloom.dtos.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class NewOrderServlet extends HttpServlet {
    ServletConfig myConfig;

    @Override
    public void init(ServletConfig arg0) throws ServletException {
        myConfig=arg0;
        System.out.println("Init!!!!!");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String isLoggedIn = (String) session.getAttribute("loggedIn");
        if (isLoggedIn != null && isLoggedIn.equals("true")) {
            UserDto user = (UserDto) session.getAttribute("User");
            String address = request.getParameter("address");

            OrderServices orderServices = new OrderServices();
            CustomValidationMessage customValidationMessage = orderServices.createNewOrder(address, user.getId());

            PrintWriter out = response.getWriter();
            System.out.println(new Gson().toJson(customValidationMessage).toString());
            out.print(new Gson().toJson(customValidationMessage));
        }

    }
}
