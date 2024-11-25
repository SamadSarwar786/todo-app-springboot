package com.example.TodoApp.Controller;

import com.example.TodoApp.Dtos.RequestDtos.RegisterUserDto;
import com.example.TodoApp.Dtos.ResponseDtos.UserResponseDto;
import com.example.TodoApp.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("register")
    public String register(){
        return "register successfully";

    }
//    @PostMapping("register")
//    public String addUser(@Valid @RequestBody RegisterUserDto registerUserDto){
//        System.out.println("checkingUsername "+ registerUserDto.getUsername()+" "+"password "+ registerUserDto.getPassword()+" gender "+ registerUserDto.getGender()+" email "+ registerUserDto.getGender());
//         return userService.addUser(registerUserDto);
//    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("api/users/getAllUser")
    public List<UserResponseDto> getAllUser(){
        return userService.getAllUser();
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("api/users/deleteUser/{userId}")
    public String deleteUser(@PathVariable Long userId){
        return userService.deleteUser(userId);
    }
}
