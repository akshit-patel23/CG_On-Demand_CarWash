package com.itransform.user_service.service.impl;


import com.itransform.user_service.dto.UserDto;
import com.itransform.user_service.entity.User;
import com.itransform.user_service.repository.UserRepository;
import com.itransform.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    private UserDto mapToDto(User user){
        return new UserDto(user.getId(),user.getName(),user.getEmail(),user.getPhone(),user.getRole());
    }

    private User mapToEntity(UserDto dto){
        User user=new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setRole(dto.getRole());
        return user;
    }
    @Override
    public UserDto createUser(UserDto userDto) {
        User user=mapToEntity(userDto);
        user.setRole("user");
        return mapToDto(userRepository.save(user));
    }

    @Override
    public UserDto getUserById(UUID id){
        return userRepository.findById(id).map(this::mapToDto)
                .orElseThrow(()->new RuntimeException("User not found"));
    }
    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UUID id,UserDto dto){
        return userRepository.findById(id).map(existing->{
            existing.setName(dto.getName());
            existing.setEmail(dto.getEmail());
            existing.setPhone(dto.getPhone());
            return mapToDto(userRepository.save(existing));

        }).orElse(null);

    }
    @Override
    public void deleteUser(UUID id){
        userRepository.deleteById(id);
    }

}
