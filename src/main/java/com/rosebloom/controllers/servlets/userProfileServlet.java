package com.rosebloom.controllers.servlets;

import com.rosebloom.controllers.services.UserServices;
import com.rosebloom.dtos.UserDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

public class userProfileServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        System.out.println("Signup page");
        String name = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Date birthday = Date.valueOf(request.getParameter("birthday"));
        String phoneNo = request.getParameter("phoneNo");
        String address = request.getParameter("address");
        int creditLimit = Integer.parseInt(request.getParameter("creditLimit"));
        String job = request.getParameter("job");

        HttpSession session = request.getSession();
        UserDto mainUser = (UserDto)session.getAttribute("User");

        UserServices userServices = new UserServices();

        if(!userServices.checkByEmailIfValid(email) || mainUser.getEmail()==email) {
            System.out.println("Update User ;) ");
            UserDto user= new UserDto(mainUser.getId(),name,password,email,address,birthday,phoneNo,creditLimit,job);
            userServices.UpdateUserDetails(user);
            user = userServices.getUserByEmail(email,password);

            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);


        }else{
            System.out.println("this User is already used :( ");
            RequestDispatcher rd = request.getRequestDispatcher("/signup2.html");
            rd.forward(request, response);
        }





    }


}
