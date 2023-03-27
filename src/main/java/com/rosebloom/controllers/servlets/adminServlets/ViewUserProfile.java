package com.rosebloom.controllers.servlets.adminServlets;

import java.io.IOException;
import java.util.List;

import com.rosebloom.controllers.services.UserServices;
import com.rosebloom.dtos.UserDto;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class ViewUserProfile extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("userId"));

        UserServices userServices = new UserServices();
        UserDto user = userServices.getUserById(id);

        request.setAttribute("userProfile", user);

        request.getRequestDispatcher("adminView/html/viewUserProfile.jsp").forward(request, response);
   
    }
}
