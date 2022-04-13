package com.houarizegai.springopenfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringOpenFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringOpenFeignApplication.class, args);
    }

}
