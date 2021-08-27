package com.houarizegai.httptrace.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HouariZegai, created on 12/04/2021
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello world!";
    }
}
