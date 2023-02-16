package com.houarizegai.springsecurityldap.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public ResponseEntity<List<String>> getUsers() {
        List<String> users = Collections.singletonList("Houari");

        return ResponseEntity.ok(users);
    }
}
