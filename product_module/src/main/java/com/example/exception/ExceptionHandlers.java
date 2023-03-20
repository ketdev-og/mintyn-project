package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(value={BadRequest.class})
    public ResponseEntity<Object> handleProductBadRequest(BadRequest e) {
        BaseException baseException = new BaseException(
                e.getMessage(),
                e.getCause(),
                HttpStatus.BAD_REQUEST
                );
        return new ResponseEntity<>(baseException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {NotFound.class})
    public ResponseEntity<Object> handleNotFound(NotFound e){
        BaseException baseException = new BaseException(
                e.getMessage(),
                e.getCause(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(baseException, HttpStatus.NOT_FOUND);
    }
}
