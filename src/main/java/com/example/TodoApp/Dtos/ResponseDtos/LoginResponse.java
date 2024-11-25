package com.example.TodoApp.Dtos.ResponseDtos;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;

    private long expiresIn;


    // Getters and setters...
}
