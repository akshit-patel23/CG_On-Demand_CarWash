package com.itransform.user_service.service;



import com.itransform.user_service.dto.UserDto;
import com.itransform.user_service.entity.User;

import java.util.List;
import java.util.UUID;
public interface UserService {

    UserDto createUser(UserDto userDto);
    UserDto getUserById(UUID id);
    List<UserDto> getAllUsers();
    UserDto updateUser(UUID id,UserDto userDto);
    void deleteUser(UUID id);
}
