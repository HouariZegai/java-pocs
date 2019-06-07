package com.houarizegai.springcrmrest.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomerRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException cException) {
        CustomerErrorResponse customerErrorResponse = new CustomerErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                cException.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(customerErrorResponse, HttpStatus.NOT_FOUND);
    }

    // for catch any exception
    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(Exception e) {
        CustomerErrorResponse customerErrorResponse = new CustomerErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                e.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity(customerErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
