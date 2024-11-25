package com.example.TodoApp.Repositories;

import com.example.TodoApp.Enums.RoleEnum;
import com.example.TodoApp.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleEnum name);
}
