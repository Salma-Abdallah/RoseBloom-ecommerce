package com.rosebloom.controllers.mappers;

import com.rosebloom.dtos.OrderDetailsDto;
import com.rosebloom.controllers.persistence.entities.OrderDetails;
import org.mapstruct.*;
import org.mapstruct.Mapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI, uses = {ProductMapper.class})
public interface OrderDetailsMapper {
    OrderDetails toEntity(OrderDetailsDto orderDetailsDto);

    OrderDetailsDto toDto(OrderDetails orderDetails);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    OrderDetails partialUpdate(OrderDetailsDto orderDetailsDto, @MappingTarget OrderDetails orderDetails);
}