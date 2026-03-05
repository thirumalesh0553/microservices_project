package com.priacc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalHandlerException {
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleEmployeeNotFoundException(EmployeeNotFoundException dnfe){
        ErrorMessage errorMessage=new ErrorMessage(dnfe.getMessage(),new Date(), HttpStatus.NOT_FOUND.name());
        return new  ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
    }
}

