package com.vrx.dinehub.service;

import com.vrx.dinehub.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto saveUser(UserDto userDto);

    List<UserDto> fetchAllUsers();

    UserDto fetchUserById(String userId);
}
