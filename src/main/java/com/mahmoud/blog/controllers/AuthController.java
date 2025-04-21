package com.mahmoud.blog.controllers;

import com.mahmoud.blog.domain.dtos.AuthResponse;
import com.mahmoud.blog.domain.dtos.LoginRequest;
import com.mahmoud.blog.domain.dtos.RegisterRequest;
import com.mahmoud.blog.services.AuthenticationService;
import com.mahmoud.blog.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest registerRequest) {
        // Register the user
        userService.registerUser(registerRequest);

        // Authenticate the newly registered user
        UserDetails user = authenticationService.authenticate(
                registerRequest.getEmail(),
                registerRequest.getPassword()
        );

        // Generate and return the JWT token
        AuthResponse authResponse = AuthResponse.builder()
                .token(authenticationService.generateToken(user))
                .expireIn(86400)
                .build();

        return new ResponseEntity<>(authResponse, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        UserDetails user = authenticationService.authenticate(
                loginRequest.getEmail(),
                loginRequest.getPassword()
        );
        AuthResponse authResponse = AuthResponse.builder()
                .token(authenticationService.generateToken(user))
                .expireIn(86400)
                .build();

        return ResponseEntity.ok(authResponse);
    }
}
