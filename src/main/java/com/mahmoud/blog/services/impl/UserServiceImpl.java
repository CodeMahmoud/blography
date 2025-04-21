package com.mahmoud.blog.services.impl;

import com.mahmoud.blog.domain.dtos.RegisterRequest;
import com.mahmoud.blog.domain.entities.User;
import com.mahmoud.blog.domain.repositories.UserRepository;
import com.mahmoud.blog.services.UserService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User getUserById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }

    @Override
    @Transactional
    public User registerUser(RegisterRequest registerRequest) {
        // Check if user with email already exists
        if (userRepository.findByEmail(registerRequest.getEmail()).isPresent()) {
            throw new EntityExistsException("User with email " + registerRequest.getEmail() + " already exists");
        }

        // Create new user
        User newUser = User.builder()
                .name(registerRequest.getName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .build();

        return userRepository.save(newUser);
    }
} 