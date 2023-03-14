package com.rosebloom.controllers.mappers;

import com.rosebloom.dtos.CartDto;
import com.rosebloom.controllers.persistence.entities.Cart;
import org.mapstruct.*;
import org.mapstruct.Mapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI, uses = {ProductMapper.class})
public interface CartMapper {
    Cart toEntity(CartDto cartDto);

    CartDto toDto(Cart cart);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Cart partialUpdate(CartDto cartDto, @MappingTarget Cart cart);
}