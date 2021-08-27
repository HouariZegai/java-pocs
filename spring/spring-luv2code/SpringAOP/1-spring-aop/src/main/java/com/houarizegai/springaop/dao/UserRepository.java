package com.houarizegai.springaop.dao;

import com.houarizegai.springaop.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserRepository {

    public void save() {
        System.out.println("Do my DB work: save user to db");
    }

    public void save(User user) {
        System.out.printf("Do my DB work: saving user %s (%d) to db", user.getName(), user.getId());
    }
}
