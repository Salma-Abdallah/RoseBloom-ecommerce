package com.rosebloom.controllers.services;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.rosebloom.controllers.enums.OrderStatus;

import com.rosebloom.controllers.mappers.OrdersMapper;
import com.rosebloom.controllers.persistence.entities.Orders;
import com.rosebloom.controllers.persistence.repository.OrderRepository;
import com.rosebloom.controllers.utils.CustomValidationMessage;

import com.rosebloom.dtos.CartDto;
import com.rosebloom.dtos.OrderDetailsDto;
import com.rosebloom.dtos.OrdersDto;

public class OrderServices {
    OrderRepository orderRepository;
     public OrderServices (){
         orderRepository = new OrderRepository();
     }

    public CustomValidationMessage createNewOrder(String address, Integer userId){

        CartServices cartServices = new CartServices();
        List<CartDto> cartList = cartServices.getAllCartItemsByUserId(userId);

        cartList.removeIf((cartItem) -> (cartItem.getProduct().getQuantity() < 1 || cartItem.getProduct().getIsDeleted() == 1));

        List<OrderDetailsDto> orderDetailsDtos = cartList.stream().map((cart) -> {
            return new OrderDetailsDto(cart.getProduct(), cart.getQuantity(), (double) cart.getQuantity() * cart.getProduct().getPrice());
        }).collect(Collectors.toList());

        Set<OrderDetailsDto> orderDetailsDtosSet = new HashSet<>(orderDetailsDtos);

        OrdersDto ordersDto = new OrdersDto();
        ordersDto.setOrderDate(Timestamp.valueOf(LocalDateTime.now()));
        ordersDto.setAddress(address);
        ordersDto.setStatus(OrderStatus.PROCESSING.name());
        ordersDto.setOrderDetailses(orderDetailsDtosSet);

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
