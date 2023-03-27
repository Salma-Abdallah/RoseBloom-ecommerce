package com.rosebloom.controllers.services;

import java.util.ArrayList;
import java.util.List;

import com.rosebloom.controllers.enums.OrderStatus;

import com.rosebloom.controllers.mappers.OrdersMapper;
import com.rosebloom.controllers.persistence.entities.Orders;
import com.rosebloom.controllers.persistence.repository.OrderRepository;
import com.rosebloom.controllers.utils.CustomValidationMessage;

import com.rosebloom.dtos.OrdersDto;

public class OrderServices {
    OrderRepository orderRepository;
     public OrderServices (){
         orderRepository = new OrderRepository();
     }

    public CustomValidationMessage createNewOrder(OrdersDto ordersDto, Integer userId){
        return orderRepository.createNewOrder(OrdersMapper.toEntity(ordersDto), userId);
    }

    public CustomValidationMessage changeOrderStatus(Integer orderId, OrderStatus status){
        return orderRepository.changeOrderStatus(orderId,status);
    }

    public List<OrdersDto> getAllOrders(){
        orderRepository = new OrderRepository();
        List<Orders> orders = orderRepository.getAllOrders();

        List<OrdersDto> ordersDtos = new ArrayList<>();
        OrdersMapper mapper = new OrdersMapper();

        for(Orders order : orders){
            ordersDtos.add(mapper.toDto(order));
        }

        return ordersDtos;
    }
}
