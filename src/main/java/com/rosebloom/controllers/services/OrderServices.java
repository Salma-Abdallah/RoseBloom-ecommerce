package com.rosebloom.controllers.services;

import com.rosebloom.controllers.enums.OrderStatus;

import com.rosebloom.controllers.mappersImpl.OrdersMapper;
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
}
