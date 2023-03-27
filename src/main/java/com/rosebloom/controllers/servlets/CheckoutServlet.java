package com.rosebloom.controllers.servlets;

import com.rosebloom.controllers.services.CartServices;
import com.rosebloom.dtos.CartDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class CheckoutServlet extends HttpServlet {
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
        Integer userId = 1; //TODO get actual userId
        CartServices cartServices = new CartServices();


        List<CartDto> cartList = cartServices.getAllCartItemsByUserId(userId);
        float sum = 0.0F;
        for (CartDto cart:cartList)sum+=cart.getQuantity()*cart.getProduct().getPrice();

        request.setAttribute("cartList",cartList);
        request.setAttribute("total",sum);


        RequestDispatcher dispatcher = request.getRequestDispatcher("view/html/checkout2.jsp");
        dispatcher.forward(request, response);
//        ArrayList<CartDto> shoppingCartItems =
//        request.setAttribute(RequestAttributes.SHOPPING_CART.name(),);
    }
}
