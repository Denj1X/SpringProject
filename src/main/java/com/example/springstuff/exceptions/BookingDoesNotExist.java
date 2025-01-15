package com.example.springstuff.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class BookingDoesNotExist extends RuntimeException {
}
