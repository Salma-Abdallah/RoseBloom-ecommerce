package com.rosebloom.controllers.services;

import com.rosebloom.controllers.mappers.UserMapper;
import com.rosebloom.controllers.persistence.repository.UserRepository;
import com.rosebloom.controllers.persistence.entities.User;
import com.rosebloom.dtos.UserDto;

public class UserServices {

    public void insertUser(UserDto userDto){
        UserRepository userRepository = new UserRepository();
        UserMapper userMapper= new UserMapper();
        User userEntity= userMapper.toEntity(userDto);

        userRepository.insertUser(userEntity);
    }

    public Boolean checkIfUserIsValid(String email, String password){
        UserRepository userRepository = new UserRepository();
        Boolean result = userRepository.checkIfUserIsValid(email , password);

        return result;
    }
    public UserDto getUserByEmail(String email , String password){
        UserRepository userRepository = new UserRepository();
        User user = userRepository.getUserByEmail(email,password);
        UserMapper userMapper = new UserMapper();

        UserDto userDto = userMapper.toDto(user);

        return userDto;
    }

    public Boolean checkByEmailIfValid(String email){
        UserRepository userRepository = new UserRepository();
        Boolean result = userRepository.checkByEmailIfValid(email);

        return result;
    }

    // UpdateUserDetails

    //getAllUsers
}
