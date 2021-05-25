package com.houarizegai.handleexceptions.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

/**
 * @author HouariZegai, created on 25/05/2021
 */
@Getter
@Setter
@RequiredArgsConstructor
public class ApiException {

    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;
    private final ZonedDateTime zonedDateTime;
}
