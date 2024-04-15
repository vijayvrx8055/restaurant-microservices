package com.vrx.dinehub.service.impl;

import com.vrx.dinehub.dto.UserDto;
import com.vrx.dinehub.entity.User;
import com.vrx.dinehub.mapper.UserMapper;
import com.vrx.dinehub.repo.UserRepository;
import com.vrx.dinehub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto saveUser(UserDto userDto) {
        User user = UserMapper.MAPPER.mapUserDtoToUser(userDto);
        user.setUserId(UUID.randomUUID().toString());
        User saved = userRepository.save(user);
        return UserMapper.MAPPER.mapUserToUserDto(saved);
    }

    @Override
    public List<UserDto> fetchAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper.MAPPER::mapUserToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto fetchUserById(String userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.map(UserMapper.MAPPER::mapUserToUserDto)
                .orElse(null);
    }
}
