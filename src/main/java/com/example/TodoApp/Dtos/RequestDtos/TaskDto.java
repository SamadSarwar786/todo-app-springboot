package com.example.TodoApp.Dtos.RequestDtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TaskDto {

    @NotNull
    private String title;

    private String description;

    private boolean completed = false;

}
