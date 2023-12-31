package com.example.ior.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class IorExceptionHandler {
    @ExceptionHandler(IorException.class)
    public ResponseEntity<String> counterErrorHandler(IorException counterException) {
        String msg = "Error ";
        log.info(msg + counterException.getMessage());
        return new ResponseEntity<>(counterException.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
