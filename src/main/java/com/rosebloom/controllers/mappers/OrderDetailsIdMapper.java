package com.rosebloom.controllers.mappers;

import com.rosebloom.controllers.persistence.entities.OrderDetailsId;
import com.rosebloom.dtos.OrderDetailsIdDto;

public class OrderDetailsIdMapper {
    
    public static OrderDetailsId toEntity(OrderDetailsIdDto orderDetailsIdDto) {
        if ( orderDetailsIdDto == null ) {
            return null;
        }

        OrderDetailsId orderDetailsId = new OrderDetailsId();

        orderDetailsId.setOrderId( orderDetailsIdDto.getOrderId() );
        orderDetailsId.setProductId( orderDetailsIdDto.getProductId() );

        return orderDetailsId;
    }
    
    public static OrderDetailsIdDto toDto(OrderDetailsId orderDetailsId) {
        if ( orderDetailsId == null ) {
            return null;
        }

        OrderDetailsIdDto orderDetailsIdDto = new OrderDetailsIdDto();

        orderDetailsIdDto.setOrderId( orderDetailsId.getOrderId() );
        orderDetailsIdDto.setProductId( orderDetailsId.getProductId() );

        return orderDetailsIdDto;
    }
    
    public static OrderDetailsId partialUpdate(OrderDetailsIdDto orderDetailsIdDto, OrderDetailsId orderDetailsId) {
        if ( orderDetailsIdDto == null ) {
            return orderDetailsId;
        }

        orderDetailsId.setOrderId( orderDetailsIdDto.getOrderId() );
        orderDetailsId.setProductId( orderDetailsIdDto.getProductId() );

        return orderDetailsId;
    }
}
