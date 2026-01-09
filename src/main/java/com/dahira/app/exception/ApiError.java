package com.dahira.app.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Data
@AllArgsConstructor
public class ApiError {
    private int status;
    private String message;
    private Instant timestamp;

    public ApiError(HttpStatus httpStatus, String message, Instant timestamp) {
        this.status = httpStatus.value();
        this.message = message;
        this.timestamp = timestamp;

    }
}