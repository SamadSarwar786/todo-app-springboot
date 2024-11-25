package com.example.TodoApp.Services;

import com.example.TodoApp.Dtos.RequestDtos.RegisterUserDto;
import com.example.TodoApp.Dtos.ResponseDtos.UserResponseDto;
import com.example.TodoApp.Enums.RoleEnum;
import com.example.TodoApp.Model.Role;
import com.example.TodoApp.Model.User;
import com.example.TodoApp.Repositories.RoleRepo;
import com.example.TodoApp.Repositories.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    ModelMapper modelMapper;

    public List<UserResponseDto> getAllUser() {
        List<User> userList = userRepo.findAll();

        List<UserResponseDto> userResponseDtosList = new ArrayList<>();
        userList.forEach(user -> {
           UserResponseDto userResponseDto = modelMapper.map(user,UserResponseDto.class);
           userResponseDtosList.add(userResponseDto);
        });

        return userResponseDtosList;

    }

    public String deleteUser(Long id) {
        if (userRepo.findById(id).isPresent()) { //if user exists
            userRepo.deleteById(id);
            return "User deleted successfully";
        } else return "User not found";
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("inside loadUserByUsername");
        User user = userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        System.out.println("loadUserByUsername after");
        return user;
    }
}
