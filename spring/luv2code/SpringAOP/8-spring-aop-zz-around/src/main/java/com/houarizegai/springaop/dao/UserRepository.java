package com.houarizegai.springaop.dao;

import com.houarizegai.springaop.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class UserRepository {

    public List<User> findAll() {
        try {
            TimeUnit.SECONDS.sleep(5L); // sleep 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return List.of(
                new User(1, "Mohamed"),
                new User(2, "Houari")
        );
    }

    public void save() {
        System.out.println("Do my DB work: save user to db");
    }

    public void save(User user) {
        System.out.printf("Do my DB work: saving user %s (%d) to db\n", user.getName(), user.getId());
    }
}
