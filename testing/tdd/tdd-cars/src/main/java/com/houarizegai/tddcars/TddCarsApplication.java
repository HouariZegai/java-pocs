package com.houarizegai.tddcars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TddCarsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TddCarsApplication.class, args);
    }

}
