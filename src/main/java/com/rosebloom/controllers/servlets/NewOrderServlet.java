package com.rosebloom.controllers.servlets;

import com.google.gson.Gson;
import com.rosebloom.controllers.enums.OrderStatus;
import com.rosebloom.controllers.services.CartServices;
import com.rosebloom.controllers.services.OrderServices;
import com.rosebloom.controllers.utils.CustomValidationMessage;
import com.rosebloom.dtos.CartDto;
import com.rosebloom.dtos.OrderDetailsDto;
import com.rosebloom.dtos.OrdersDto;
import com.rosebloom.dtos.ProductDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class NewOrderServlet extends HttpServlet {
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
        String address = request.getParameter("address");

        CartServices cartServices = new CartServices();
        List<CartDto> cartList = cartServices.getAllCartItemsByUserId(userId);
        List<OrderDetailsDto> orderDetailsDtos = cartList.stream().map((cart)->{
            return new OrderDetailsDto(cart.getProduct(),cart.getQuantity(),(double)cart.getQuantity()*cart.getProduct().getPrice());
        }).collect(Collectors.toList());
        Set<OrderDetailsDto> orderDetailsDtosSet = new HashSet<>(orderDetailsDtos);


        OrdersDto ordersDto = new OrdersDto();
        ordersDto.setOrderDate(Timestamp.valueOf(LocalDateTime.now()));
        ordersDto.setAddress(address);
        ordersDto.setStatus(OrderStatus.PROCESSING.name());
        ordersDto.setOrderDetailses(orderDetailsDtosSet);

        OrderServices orderServices = new OrderServices();
        CustomValidationMessage customValidationMessage = orderServices.createNewOrder(ordersDto,userId);

            PrintWriter out = response.getWriter();
            System.out.println(new Gson().toJson(customValidationMessage).toString());
            out.print(new Gson().toJson(customValidationMessage));


//        request.setAttribute("cartList",cartList);
//        request.setAttribute("total",sum);


//        RequestDispatcher dispatcher = request.getRequestDispatcher("view/html/checkout2.jsp");
//        dispatcher.forward(request, response);
//        ArrayList<CartDto> shoppingCartItems =
//        request.setAttribute(RequestAttributes.SHOPPING_CART.name(),);
    }
}
