package com.houarizegai.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.houarizegai.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {

    // define bean for our sad fortune service
    @Bean // the name of method is the bean id
    public FortuneService sadFortuneService() {
        return new SadFortuneService();
    }

    // define bean for our swim coach and inject dependency
    @Bean
    public Coach swimCoach() {
        System.out.println("SwimCoach() called");
        return new SwimCoach(sadFortuneService());
    }

}
