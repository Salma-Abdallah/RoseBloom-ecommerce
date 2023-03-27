package com.rosebloom.controllers.mappers;

import com.rosebloom.controllers.persistence.entities.User;
import com.rosebloom.dtos.UserDto;

public class UserMapper{
    public UserDto toDto(User user){
        UserDto userDto = new UserDto(user.getId(),user.getName(), user.getPassword(), user.getEmail(), user.getAddress(), user.getBirthdate(), user.getPhone(), user.getCreditLimit(), user.getJob(), user.getIsAdmin(), user.getIsDeleted(), null, null, null);
       
        return userDto;
    }

    public User toEntity(UserDto userDto){
        System.out.println("in Mapper (userDto.getId)-> "+userDto.getId());
        User user= new User(userDto.getId(),userDto.getName(), userDto.getPassword(), userDto.getEmail(), userDto.getAddress(), userDto.getBirthdate(), userDto.getPhone(), userDto.getCreditLimit(), userDto.getJob(),userDto.getIsAdmin(), userDto.getIsDeleted(), null,null,null );
        System.out.println("in Mapper (user.getId)-> "+user.getId());

        return user;
    }
}





// import com.rosebloom.dtos.UserDto;
// import com.rosebloom.controllers.persistence.entities.User;
// import org.mapstruct.*;
// import org.mapstruct.Mapper;

// @Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
// public interface UserMapper {
//     User toEntity(UserDto userDto);

//     UserDto toDto(User user);

//     @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//     User partialUpdate(UserDto userDto, @MappingTarget User user);

//     @AfterMapping
//     default void linkCarts(@MappingTarget User user) {
//         user.getCarts().forEach(cart -> cart.setUser(user));
//     }

//     @AfterMapping
//     default void linkOrderses(@MappingTarget User user) {
//         user.getOrderses().forEach(orders -> orders.setUser(user));
//     }
// }