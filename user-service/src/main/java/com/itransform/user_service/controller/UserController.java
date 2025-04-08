package com.itransform.user_service.controller;

import com.itransform.user_service.dto.UserDto;
import com.itransform.user_service.entity.User;


import com.itransform.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")

public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable UUID id){
        return userService.getUserById(id);
    }
    @PostMapping("/add")
    public UserDto createUser(@RequestBody UserDto dto){

        return userService.createUser(dto);
    }

    @PutMapping("update/{id}")
    public UserDto updateUser(@PathVariable UUID id,@RequestBody UserDto dto){
        return userService.updateUser(id,dto);
    }

    @DeleteMapping("delete/{id}")
    public String deleteUser(@PathVariable UUID id){
        userService.deleteUser(id);
        return "User Deleted Successfully";
    }
}
