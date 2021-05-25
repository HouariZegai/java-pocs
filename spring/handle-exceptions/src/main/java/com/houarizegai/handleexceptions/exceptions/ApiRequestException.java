package com.houarizegai.handleexceptions.exceptions;

/**
 * @author HouariZegai, created on 25/05/2021
 */
public class ApiRequestException extends RuntimeException {

    public ApiRequestException(String message) {
        super(message);
    }

    public ApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
