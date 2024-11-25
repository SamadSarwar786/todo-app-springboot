package com.example.TodoApp.Controller;

import com.example.TodoApp.Dtos.RequestDtos.TaskDto;
import com.example.TodoApp.Model.Task;
import com.example.TodoApp.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/")
    public String home(){
        return "home";
    }
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping("api/todos/{userId}")
    public List<Task> getAllTodosPerUser(@PathVariable Long userId){
        return taskService.getAllTasksPerUser(userId);
    }
    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("api/todos/{userId}")
    public String addTask(@PathVariable Long userId, @RequestBody TaskDto taskDto){
         return taskService.addTask(userId, taskDto);
    }
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("api/todos")
    public List<Task> getAllTodos(){
        return taskService.getAllTasks();
    }
}
