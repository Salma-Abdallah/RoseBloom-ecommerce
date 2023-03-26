package com.rosebloom.controllers.mappers;

import com.rosebloom.controllers.persistence.entities.OrderDetailsId;
import com.rosebloom.dtos.OrderDetailsIdDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface OrderDetailsIdMapper {
    OrderDetailsId toEntity(OrderDetailsIdDto orderDetailsIdDto);

    OrderDetailsIdDto toDto(OrderDetailsId orderDetailsId);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    OrderDetailsId partialUpdate(OrderDetailsIdDto orderDetailsIdDto, @MappingTarget OrderDetailsId orderDetailsId);
}