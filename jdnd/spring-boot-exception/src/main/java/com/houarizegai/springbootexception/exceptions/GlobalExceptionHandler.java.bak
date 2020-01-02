package com.houarizegai.springbootexception.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = java.lang.ArithmeticException.class)
    public ModelAndView handleArithmeticException(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", String.valueOf(e));
        modelAndView.setViewName("mathError");

        return modelAndView;
    }

    @ExceptionHandler(value = java.lang.NullPointerException.class)
    public ModelAndView handleNullPointerException(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", String.valueOf(e));
        modelAndView.setViewName("nullPointerError");

        return modelAndView;
    }
}
