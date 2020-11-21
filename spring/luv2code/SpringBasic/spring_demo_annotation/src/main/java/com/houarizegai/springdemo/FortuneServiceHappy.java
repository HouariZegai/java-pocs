package com.houarizegai.springdemo;

import org.springframework.stereotype.Component;

@Component
public class FortuneServiceHappy implements FortuneService {

    public String getFortune() {
        return "Today is your lucky day!";
    }

}
