package com.houarizegai.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {

    // expose "/" that return "Hello World!"
    @GetMapping("/")
    public String sayHello() {
        return "Hello World!, Time on the server is: " + LocalDateTime.now();
    }

    // Expose a new end point "fortune"
    @GetMapping("/fortune")
    public String getFortune() {
        return "Today is your lucky day.";
    }
}
