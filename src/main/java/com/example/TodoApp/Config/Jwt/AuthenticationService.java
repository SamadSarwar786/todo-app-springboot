package com.example.TodoApp.Config.Jwt;

import com.example.TodoApp.Dtos.RequestDtos.LoginUserDto;
import com.example.TodoApp.Dtos.RequestDtos.RegisterUserDto;
import com.example.TodoApp.Enums.RoleEnum;
import com.example.TodoApp.Exceptions.UserAlreadyExistsException;
import com.example.TodoApp.Model.Role;
import com.example.TodoApp.Model.User;
import com.example.TodoApp.Repositories.RoleRepo;
import com.example.TodoApp.Repositories.UserRepo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthenticationService {
    private final UserRepo userRepo;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final RoleRepo roleRepo;

    public AuthenticationService(
            UserRepo userRepo,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder,
            RoleRepo roleRepo
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.roleRepo = roleRepo;
    }

    public User signup(RegisterUserDto registerUserDto) throws Exception {
        if (userRepo.findByUsername(registerUserDto.getUsername()).isPresent()) {
            System.out.println("User already exists print");
            throw new UserAlreadyExistsException();
        }

        User user = new User();
        user.setGender(registerUserDto.getGender());
        user.setUsername(registerUserDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerUserDto.getPassword()));

        Set<Role> roles = new HashSet<>();
        for (RoleEnum roleName : registerUserDto.getRoleNames()) {
            Optional<Role> role = roleRepo.findByName(roleName);
            if (role.isPresent()) {
                roles.add(role.get());
            } else {
                // Optionally handle the case where the role doesn't exist
                Role newRole = new Role();
                newRole.setName(roleName);
                roles.add(newRole);
                System.out.println("Role " + roleName + " not found.");
            }
        }
        user.setRoles(roles);
        return userRepo.save(user);
    }

    public User authenticate(LoginUserDto loginUserDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUserDto.getUsername(),
                        loginUserDto.getPassword()
                )
        );

        return userRepo.findByUsername(loginUserDto.getUsername())
                .orElseThrow();
    }
}