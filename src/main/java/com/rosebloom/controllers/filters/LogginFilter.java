package com.rosebloom.controllers.filters;

import java.io.IOException;

import com.rosebloom.dtos.UserDto;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.*;

public class LogginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
                System.out.println("filter................");
                HttpServletRequest httpServletRequest = (HttpServletRequest)request;
                HttpSession session = httpServletRequest.getSession();
                String isLoggedIn = (String) session.getAttribute("loggedIn");
                
                if (isLoggedIn == null || !isLoggedIn.equals("true")) {
                    request.getRequestDispatcher("login2.html").forward(request, response);   
                }
                else 
                {
                    UserDto user = (UserDto) session.getAttribute("User");
                    if(user.getIsAdmin()!=1){
                        request.getRequestDispatcher("login2.html").forward(request, response);
                    }
                }
                chain.doFilter(request, response);
    }

    
}
