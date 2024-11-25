package com.example.TodoApp.Repositories;

import com.example.TodoApp.Model.Task;
import com.example.TodoApp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepo extends JpaRepository<Task, Long> {
    List<Task> findByUserId(Long userId);
}
