package com.example.TodoApp.Services;

import com.example.TodoApp.Dtos.RequestDtos.TaskDto;
import com.example.TodoApp.Model.Task;
import com.example.TodoApp.Model.User;
import com.example.TodoApp.Repositories.TaskRepo;
import com.example.TodoApp.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class TaskService {

    @Autowired
    TaskRepo taskRepo;

    @Autowired
    UserRepo userRepo;

    public String addTask(Long userId, TaskDto taskDto) {
        Optional<User> userOpt = userRepo.findById(userId);
        if(userOpt.isEmpty()) {
//            throw new UserDoesNotExists();
            return "User does not exist";
        }

        User user = userOpt.get();

        Task task = new Task();
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setCompleted(taskDto.isCompleted());
        task.setUser(user);
        taskRepo.save(task);
//        return task;
        return "task added successfully";
    }
    public void deleteTask() {

    }
    public void updateTask() {

    }
    public List<Task> getAllTasksPerUser(Long userId) {
        Optional<User> userOpt = userRepo.findById(userId);
        if(userOpt.isEmpty()) {
//            throw new UserDoesNotExists();
            return new ArrayList<>();
        }

        User user = userOpt.get();

        return taskRepo.findByUserId(user.getId());
    }

    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }
}
