package com.example.userservice.controllers;

import com.example.userservice.dtos.LoginRequestDto;
import com.example.userservice.dtos.LogoutRequestDto;
import com.example.userservice.dtos.SignUpRequestDto;
import com.example.userservice.dtos.UserDto;
import com.example.userservice.dtos.UserToken;
import com.example.userservice.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Login
    @PostMapping("/login")
    public UserToken login(@RequestBody LoginRequestDto loginRequestDto) {
        String token = authService.login(loginRequestDto.getEmail(), loginRequestDto.getPassword());
        return new UserToken(token);
    }

    @PostMapping("/signup")
    public UserDto signUp(@RequestBody SignUpRequestDto signUpRequestDto) {
        return UserDto.fromUser(authService.signUp(signUpRequestDto.getName(), signUpRequestDto.getEmail(), signUpRequestDto.getPassword()));
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestBody LogoutRequestDto logoutRequestDto) {
        authService.logout(logoutRequestDto.getToken());
        return ResponseEntity.noContent().build();
    }

    // validate token
    @GetMapping("/validate-token")
    public ResponseEntity<UserDto> validateToken(@RequestParam("token") String token) {
        return ResponseEntity.ok(UserDto.fromUser(authService.validateToken(token)));
    }
}
