package com.example.TodoApp.Dtos.RequestDtos;

import com.example.TodoApp.Enums.Gender;
import com.example.TodoApp.Enums.RoleEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;

@Data
public class RegisterUserDto {

    @NotBlank(message = "Username cannot be empty")
    private String username;

    @NotBlank(message = "Password cannot be empty")
    private String password;
    private Gender gender;
    @NotNull(message = "Role cannot be empty")
    private Set<RoleEnum> roleNames;

}
