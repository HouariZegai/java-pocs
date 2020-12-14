package com.houarizegai.springtaskschedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringTaskScheduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringTaskScheduleApplication.class, args);
    }

}
