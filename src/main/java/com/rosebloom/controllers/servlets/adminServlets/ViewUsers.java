package com.rosebloom.controllers.servlets.adminServlets;

import java.io.IOException;
import java.util.List;

import com.rosebloom.controllers.services.UserServices;
import com.rosebloom.dtos.UserDto;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class ViewUsers extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("View User servlet");
        UserServices userServices = new UserServices();
        List<UserDto> users = userServices.getAllUsers();
        request.setAttribute("users", users);

        System.out.println(users);

        request.getRequestDispatcher("adminView/product-admin-master/accounts.jsp").forward(request, response);
    }
}
