package com.rosebloom.controllers.filters;

import com.google.gson.Gson;
import com.rosebloom.controllers.services.CartServices;
import com.rosebloom.controllers.utils.CustomValidationMessage;
import com.rosebloom.dtos.CartIdDto;
import com.rosebloom.dtos.UserDto;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class CartFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(request instanceof HttpServletRequest) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            HttpSession session = httpServletRequest.getSession();
            String isLoggedIn = (String) session.getAttribute("loggedIn");
            if (isLoggedIn != null && isLoggedIn.equals("true")) {
                chain.doFilter(request, response);
            } else {
                PrintWriter out = response.getWriter();
                out.print(new Gson().toJson(new CustomValidationMessage(false,"You Must login to Use Cart")));
//                HttpServletResponse httpServletResponse = (HttpServletResponse) response;
//                httpServletResponse.sendRedirect("login2.html");
            }
        }

    }

    
}
