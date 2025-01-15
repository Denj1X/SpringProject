package com.example.springstuff.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Train does not exist")
public class TrainDoesNotExist extends RuntimeException{
}
