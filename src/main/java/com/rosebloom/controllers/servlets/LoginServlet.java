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

public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        System.out.println("Login page");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
//        System.out.println("email : "+email +"\n password : "+password);

        UserServices userServices = new UserServices();
        if(userServices.checkIfUserIsValid(email,password)) {
            System.out.println("valid User ;)");

            UserDto user = userServices.getUserByEmail(email , password);

            HttpSession session = request.getSession(true);
            session.setAttribute("loggedIn", new String("true"));
            session.setAttribute("User",user);

            System.out.println(user.getId());

            if(user.getIsAdmin()==0){
                System.out.println( "MOT an ADMIN");
                RequestDispatcher rd = request.getRequestDispatcher("/");
                rd.forward(request, response);
            }else{
                RequestDispatcher rd = request.getRequestDispatcher("/adminView/product-admin-master/index.jsp");
                // RequestDispatcher rd = request.getRequestDispatcher("ViewOrders");
                rd.forward(request, response);
            }

            

        }else{
            System.out.println("invalid User  :(");
            RequestDispatcher rd = request.getRequestDispatcher("/login2.html");
            rd.forward(request, response);
        }





    }


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        System.out.println("loginServlet");

        String email = request.getParameter("userEmail");

        UserServices userServices = new UserServices();

        if(userServices.checkByEmailIfValid(email)) {
            out.print("<font color=GREEN>Valid email </font>");
        } else
            out.print("<font color=RED>Invalid email </font>");


    }
}
