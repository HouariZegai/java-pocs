package com.houarizegai.springprofiles.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HouariZegai, created on 10/03/2021
 */
@RestController
public class HelloController {
    @GetMapping
    public String hello() {
        return "hello";
    }
}
