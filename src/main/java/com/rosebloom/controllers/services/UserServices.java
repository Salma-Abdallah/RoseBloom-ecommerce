package com.rosebloom.controllers.services;

import java.util.ArrayList;
import java.util.List;

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
    public void UpdateUserDetails(UserDto userDto){
        System.out.println("in services (userDto.getId)-> "+userDto.getId());

        UserRepository userRepository = new UserRepository();
        UserMapper userMapper= new UserMapper();
        User userEntity= userMapper.toEntity(userDto);

        System.out.println("in services (user.getId)-> "+userEntity.getId());
        userRepository.UpdateUserDetails(userEntity);
    }

    //getAllUsers
    public List<UserDto> getAllUsers(){
        UserRepository userRepository = new UserRepository();

        List<User> users = userRepository.getAllUsers();

        List<UserDto> userDtos = new ArrayList<>();
        UserMapper mapper = new UserMapper();

        for(User user :users){
            userDtos.add(mapper.toDto(user));
        }

        for(UserDto userDto :userDtos){
            System.out.println(userDto);
        }


        return userDtos;
    }

    public UserDto getUserById(int id) {
        UserRepository userRepository = new UserRepository();
        User user = userRepository.getUserById(id);
        UserMapper userMapper = new UserMapper();

        UserDto userDto = userMapper.toDto(user);

        return userDto;
    }
}
