package com.example.userservice.services;

import com.example.userservice.dtos.SignUpRequestDto;
import com.example.userservice.exceptions.LoginFailedException;
import com.example.userservice.exceptions.UserNotFoundException;
import com.example.userservice.models.User;
import com.example.userservice.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthService {
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Login
    public String login(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User with email " + email + " not found"));

        if (!Objects.equals(password, user.getHashedPassword())) {
            throw new LoginFailedException("Invalid password");
        }

        // generate and return a random token
        return "random-token";
    }

    // no need to hash password for now
    // just store user as is in the db
    // for now no need to have email verification either
    public User signUp(SignUpRequestDto signUpRequestDto) {
        User user = new User();
        user.setEmail(signUpRequestDto.getEmail());
        user.setHashedPassword(signUpRequestDto.getPassword());
        user.setName(signUpRequestDto.getName());
        return userRepository.save(user);
    }

    public void logout(String token) {
        // delete token if exists -> 200
        // if doesn't exist give a 404

    }
}
