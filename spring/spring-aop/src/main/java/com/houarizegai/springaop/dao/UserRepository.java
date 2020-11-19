package com.houarizegai.springaop.dao;

import org.springframework.stereotype.Component;

@Component
public class UserRepository {

    public void save() {
        System.out.println("Do my DB work: save user to db");
    }
}
