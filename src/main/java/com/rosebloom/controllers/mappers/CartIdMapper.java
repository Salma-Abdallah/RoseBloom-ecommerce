package com.rosebloom.controllers.mappers;

import com.rosebloom.controllers.persistence.entities.CartId;
import com.rosebloom.dtos.CartIdDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface CartIdMapper {
    CartId toEntity(CartIdDto cartIdDto);

    CartIdDto toDto(CartId cartId);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    CartId partialUpdate(CartIdDto cartIdDto, @MappingTarget CartId cartId);
}