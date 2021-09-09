package com.houarizegai.springminio.exception;

public class MinioException extends RuntimeException {

    public MinioException(String message, Throwable cause) {
        super(message, cause);
    }
}
