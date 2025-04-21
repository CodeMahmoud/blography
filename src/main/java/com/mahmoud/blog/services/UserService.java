package com.mahmoud.blog.services;

import com.mahmoud.blog.domain.dtos.RegisterRequest;
import com.mahmoud.blog.domain.entities.User;

import java.util.UUID;

public interface UserService {
    User getUserById(UUID id);
    User registerUser(RegisterRequest registerRequest);
}
