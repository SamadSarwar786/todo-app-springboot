package com.example.TodoApp.Dtos.ResponseDtos;

import com.example.TodoApp.Enums.Gender;
import com.example.TodoApp.Model.Role;
import com.example.TodoApp.Model.Task;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class UserResponseDto {
    private Long Id;

    private String username;

    private Gender gender;

    private List<Task> taskList;

    private Set<Role> roles;

}
