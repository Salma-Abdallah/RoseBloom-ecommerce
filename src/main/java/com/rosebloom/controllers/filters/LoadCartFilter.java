package com.rosebloom.controllers.filters;


import com.rosebloom.controllers.services.CartServices;
import com.rosebloom.dtos.CartDto;
import com.rosebloom.dtos.UserDto;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.List;

public class LoadCartFilter implements Filter {
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter initialized");
        this.filterConfig = filterConfig;
    }

    @Override
    public void destroy() {
        System.out.println("Filter destroyed");
        this.filterConfig = null;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        if(request instanceof HttpServletRequest) {
            HttpServletRequest httpServletRequest = (HttpServletRequest)request;
            HttpSession session = httpServletRequest.getSession();

            String isLoggedIn = (String)session.getAttribute("loggedIn");
            if (isLoggedIn!= null && isLoggedIn.equals("true")) {
                UserDto user = (UserDto) session.getAttribute("User");
                CartServices cartServices = new CartServices();

                List<CartDto> cartList = cartServices.getAllCartItemsByUserId(user.getId());
                float sum = 0.0F;
                for (CartDto cart : cartList) sum += cart.getQuantity() * cart.getProduct().getPrice();

                request.setAttribute("cartList", cartList);
                request.setAttribute("total", sum);
            }
        }
//        System.out.println("End Fil");
        chain.doFilter(request, response);
    }
}
