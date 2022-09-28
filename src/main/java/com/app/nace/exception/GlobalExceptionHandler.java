package com.app.nace.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DataMissingException.class)
    public ResponseEntity<?> globalExceptions(DataMissingException exception, WebRequest request){
        CustomErrorMessage customErrorMessage = new CustomErrorMessage(exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(customErrorMessage, HttpStatus.BAD_REQUEST);
    }
}
