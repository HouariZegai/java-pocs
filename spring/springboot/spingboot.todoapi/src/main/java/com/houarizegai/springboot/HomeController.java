package com.houarizegai.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class HomeController {

    @RequestMapping
    public String helloWorld() {
        return "Hello World, from Spring boot !";
    }

//    @GetMapping(value = "/{name}")
//    public String greetingWithName(@PathVariable String name) {
//        return String.format("Welcome %s to our spring app !", name);
//    }
}
