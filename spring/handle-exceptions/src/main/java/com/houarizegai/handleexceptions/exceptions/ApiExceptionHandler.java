package com.houarizegai.handleexceptions.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author HouariZegai, created on 25/05/2021
 */
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<?> handleApiRequestException(ApiRequestException e) {
        // 1. Create payload containing exception details
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiException apiException = new ApiException(e.getMessage(), e, badRequest,
                ZonedDateTime.now(ZoneId.of("Z")));
        // 2. Return response Entity
        return new ResponseEntity<>(apiException, badRequest);
    }
}
