package com.example.TodoApp.Config.Jwt;

import com.example.TodoApp.Dtos.RequestDtos.LoginUserDto;
import com.example.TodoApp.Dtos.RequestDtos.RegisterUserDto;
import com.example.TodoApp.Dtos.ResponseDtos.LoginResponse;
import com.example.TodoApp.Model.User;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("register")
    public ResponseEntity<User> register(@Valid @RequestBody RegisterUserDto registerUserDto) throws Exception {
        User registeredUser = authenticationService.signup(registerUserDto);

        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

    @PostMapping("login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginUserDto loginUserDto) throws Exception {
         User authenticatedUser = authenticationService.authenticate(loginUserDto);
         String token = jwtService.generateToken(authenticatedUser);

         LoginResponse loginResponse = new LoginResponse();
         loginResponse.setToken(token);
         loginResponse.setExpiresIn(jwtService.getExpirationTime());

         return ResponseEntity.ok(loginResponse);
    }
}
