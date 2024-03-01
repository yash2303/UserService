package com.example.userservice.controlleradvice;

import com.example.userservice.dtos.ExceptionDto;
import com.example.userservice.exceptions.InvalidTokenException;
import com.example.userservice.exceptions.LoginFailedException;
import com.example.userservice.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleUserNotFountException(UserNotFoundException e) {
        return new ResponseEntity<>(
                new ExceptionDto(e.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(LoginFailedException.class)
    public ResponseEntity<ExceptionDto> handleLoginFailedException(LoginFailedException e) {
        return new ResponseEntity<>(
                new ExceptionDto(e.getMessage()),
                HttpStatus.UNAUTHORIZED
        );
    }

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<ExceptionDto> handleInvalidTokenException(InvalidTokenException e) {
        return new ResponseEntity<>(
                new ExceptionDto(e.getMessage()),
                HttpStatus.UNAUTHORIZED
        );
    }
}
