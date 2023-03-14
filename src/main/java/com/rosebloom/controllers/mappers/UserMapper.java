package com.rosebloom.controllers.mappers;

import com.rosebloom.dtos.UserDto;
import com.rosebloom.controllers.persistence.entities.User;
import org.mapstruct.*;
import org.mapstruct.Mapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface UserMapper {
    User toEntity(UserDto userDto);

    UserDto toDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(UserDto userDto, @MappingTarget User user);

    @AfterMapping
    default void linkCarts(@MappingTarget User user) {
        user.getCarts().forEach(cart -> cart.setUser(user));
    }

    @AfterMapping
    default void linkOrderses(@MappingTarget User user) {
        user.getOrderses().forEach(orders -> orders.setUser(user));
    }
}