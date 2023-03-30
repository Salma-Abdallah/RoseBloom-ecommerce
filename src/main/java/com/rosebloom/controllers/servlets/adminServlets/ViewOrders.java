package com.rosebloom.controllers.servlets.adminServlets;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.util.List;

import com.rosebloom.controllers.services.OrderServices;
import com.rosebloom.dtos.OrdersDto;

public class ViewOrders extends HttpServlet {
    // public void doPost(HttpServletRequest request, HttpServletResponse response)
    //         throws ServletException, IOException {

    //     System.out.println("View Orders servlet");
    //     OrderServices orderServices = new OrderServices();
    //     List<OrdersDto> orders = orderServices.getAllOrders();

    //     System.out.println(orders);
    //     System.out.println("view orders");
    //     request.setAttribute("orders", orders);
    //     request.getRequestDispatcher("adminView/product-admin-master/index.jsp").forward(request, response);
    // }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("View Orders servlet");
        OrderServices orderServices = new OrderServices();
        List<OrdersDto> orders = orderServices.getAllOrders();

        System.out.println(orders);
        System.out.println("view orders");
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("adminView/product-admin-master/index.jsp").forward(request, response);
        
    }


}
