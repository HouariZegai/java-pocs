package com.houarizegai.springminio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler({MinioException.class})
    public ResponseEntity<ApiExceptionResponse> handleMinioException(MinioException exception) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;

        ApiExceptionResponse response = ApiExceptionResponse.builder()
                .status(httpStatus.value())
                .message(exception.getMessage())
                .build();

        return new ResponseEntity<>(response, httpStatus);
    }
}
