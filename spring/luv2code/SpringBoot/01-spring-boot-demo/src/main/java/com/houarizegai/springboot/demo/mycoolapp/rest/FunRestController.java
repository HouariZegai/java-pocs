package com.houarizegai.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {

    @Value("${teacher.name}")
    private String teacherName;

    // expose "/" that return "Hello World!"
    @GetMapping("/")
    public String sayHello() {
        return "Hello World!, Teacher: " + teacherName + ", Time on the server is: " + LocalDateTime.now();
    }
}
