package com.example.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class BaseException {
    private final String message;
    private final Throwable throwable;
    private  final HttpStatus httpStatus;

}
