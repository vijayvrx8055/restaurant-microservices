package com.vrx.dinehub.controller;

import com.vrx.dinehub.dto.UserDto;
import com.vrx.dinehub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto) {
        UserDto user = userService.saveUser(userDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> fetchAllUsers() {
        List<UserDto> users = userService.fetchAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> fetchUserById(@PathVariable String userId) {
        UserDto userDto = userService.fetchUserById(userId);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
}
