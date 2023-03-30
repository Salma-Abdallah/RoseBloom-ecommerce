package com.rosebloom.controllers.servlets;

import com.google.gson.Gson;
import com.rosebloom.controllers.services.CartServices;
import com.rosebloom.controllers.utils.CustomValidationMessage;
import com.rosebloom.dtos.CartDto;
import com.rosebloom.dtos.CartIdDto;
import com.rosebloom.dtos.UserDto;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class deleteCartItemServlet extends HttpServlet {
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

            Integer productId = Integer.parseInt(request.getParameter("productId"));
            CartIdDto cartIdDto = new CartIdDto(productId, user.getId());

            CartServices cartServices = new CartServices();
            CustomValidationMessage customValidationMessage =cartServices.deleteCartItemByCartId(cartIdDto);

            PrintWriter out = response.getWriter();
            out.print(new Gson().toJson(customValidationMessage));
        }

    }
}
