package com.rosebloom.controllers.mappers;

import com.rosebloom.dtos.OrdersDto;
import com.rosebloom.controllers.persistence.entities.Orders;
import org.mapstruct.*;
import org.mapstruct.Mapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI, uses = {OrderDetailsMapper.class})
public interface OrdersMapper {
    Orders toEntity(OrdersDto ordersDto);

    OrdersDto toDto(Orders orders);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Orders partialUpdate(OrdersDto ordersDto, @MappingTarget Orders orders);

    @AfterMapping
    default void linkOrderDetailses(@MappingTarget Orders orders) {
        orders.getOrderDetailses().forEach(orderDetails -> orderDetails.setOrders(orders));
    }
}