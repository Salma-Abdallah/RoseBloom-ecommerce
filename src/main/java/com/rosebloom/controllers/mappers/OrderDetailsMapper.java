package com.rosebloom.controllers.mappers;

import com.rosebloom.controllers.persistence.entities.OrderDetails;
import com.rosebloom.controllers.persistence.entities.Product;
import com.rosebloom.dtos.OrderDetailsDto;

public class OrderDetailsMapper {


    public OrderDetails toEntity(OrderDetailsDto orderDetailsDto) {
        if ( orderDetailsDto == null ) {
            return null;
        }


        OrderDetails orderDetails = new OrderDetails();
        ProductMapper productMapper = new ProductMapper();
        orderDetails.setProduct( productMapper.toEntity( orderDetailsDto.getProduct() ) );
        orderDetails.setQuantity( orderDetailsDto.getQuantity() );
        orderDetails.setPrice( orderDetailsDto.getPrice() );

        return orderDetails;
    }

    public OrderDetailsDto toDto(OrderDetails orderDetails) {
        if ( orderDetails == null ) {
            return null;
        }

        OrderDetailsDto orderDetailsDto = new OrderDetailsDto();
        ProductMapper productMapper = new ProductMapper();
        orderDetailsDto.setProduct( productMapper.toDto( orderDetails.getProduct() ) );
        orderDetailsDto.setQuantity( orderDetails.getQuantity() );
        orderDetailsDto.setPrice( orderDetails.getPrice() );

        return orderDetailsDto;
    }

//    public OrderDetails partialUpdate(OrderDetailsDto orderDetailsDto, OrderDetails orderDetails) {
//        if ( orderDetailsDto == null ) {
//            return orderDetails;
//        }
//
//        if ( orderDetailsDto.getProduct() != null ) {
//            if ( orderDetails.getProduct() == null ) {
//                orderDetails.setProduct( new Product() );
//            }
//            ProductMapper productMapper = new ProductMapper();
//            productMapper.partialUpdate( orderDetailsDto.getProduct(), orderDetails.getProduct() );
//        }
//        if ( orderDetailsDto.getQuantity() != null ) {
//            orderDetails.setQuantity( orderDetailsDto.getQuantity() );
//        }
//        if ( orderDetailsDto.getPrice() != null ) {
//            orderDetails.setPrice( orderDetailsDto.getPrice() );
//        }
//
//        return orderDetails;
//    }
}
