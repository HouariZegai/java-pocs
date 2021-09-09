package com.houarizegai.springminio.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ApiExceptionResponse {

    private int status;
    private String message;
}
