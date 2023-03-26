package com.rosebloom.controllers.mappers;

import com.rosebloom.controllers.persistence.entities.Cart;
import com.rosebloom.dtos.CartDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI, uses = {CartIdMapper.class, ProductMapper.class, UserMapper.class})
public interface CartMapper {
    Cart toEntity(CartDto cartDto);

    CartDto toDto(Cart cart);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Cart partialUpdate(CartDto cartDto, @MappingTarget Cart cart);
}