package com.rosebloom.controllers.filters;


import com.rosebloom.controllers.services.CartServices;
import com.rosebloom.controllers.services.UserServices;
import com.rosebloom.dtos.CartDto;
import com.rosebloom.dtos.UserDto;
import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.sql.Date;
import java.time.LocalDate;
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
            System.out.println("is Instance");
            HttpServletRequest httpServletRequest = (HttpServletRequest)request;
            HttpSession session = httpServletRequest.getSession();
            Cookie[] cookies = httpServletRequest.getCookies();

            String isLoggedIn = (String)session.getAttribute("loggedIn");
            if (isLoggedIn!= null && isLoggedIn.equals("true")) {
                UserDto user = (UserDto) session.getAttribute("User");
                CartServices cartServices = new CartServices();

                List<CartDto> cartList = cartServices.getAllCartItemsByUserId(user.getId());
                float sum = 0.0F;
                for (CartDto cart : cartList) sum += cart.getQuantity() * cart.getProduct().getPrice();

                request.setAttribute("cartList", cartList);
                request.setAttribute("total", sum);
            }else{
                System.out.println("Try Login");
                boolean isRemembered = false;
                String email = null;
                String password = null;
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("user_email")) {
                        isRemembered = true;
                        email = cookie.getValue();
                    }
                    if (cookie.getName().equals("password")) {
                        password = cookie.getValue();
                    }
                }
                if(isRemembered) {
                    UserServices userServices = new UserServices();
                    if(userServices.checkIfUserIsValid(email,password)) {
                        System.out.println("valid User ;)");
                        UserDto user = userServices.getUserByEmail(email, password);
                        session.setAttribute("loggedIn", new String("true"));
                        session.setAttribute("User", user);
                        System.out.println(user.getId());

                        if (user.getIsAdmin() == 1) {
                            HttpServletResponse httpServletResponse = (HttpServletResponse)response;
                            httpServletResponse.sendRedirect("ViewOrders");
                        }
                    }
                }else{
//                    UserServices userServices = new UserServices();
//                    System.out.println("Insert User ;) ");
//
//                    UserDto user= new UserDto("fakeAccount","123456789","aaaa"+LocalDate.now().toString()+"@gmail.com", "address",Date.valueOf(LocalDate.now()),"01111111111",0);
//                    user.setIsAdmin(-1);
//                    userServices.insertUser(user);
//                    user = userServices.getUserByEmail(email,password);
//                    session.setAttribute("loggedIn", new String("true"));
//                    session.setAttribute("User",user);
//
//                    RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
//                    rd.forward(request, response);
                }
            }
        }
        chain.doFilter(request, response);
    }
}
