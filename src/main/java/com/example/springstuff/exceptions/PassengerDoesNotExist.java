package com.example.springstuff.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Username does not exist")
public class PassengerDoesNotExist extends RuntimeException {
    public PassengerDoesNotExist(String message) {
        super(message);
    }
}
