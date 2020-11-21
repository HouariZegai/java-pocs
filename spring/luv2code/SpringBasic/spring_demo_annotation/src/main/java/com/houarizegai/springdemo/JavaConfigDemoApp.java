package com.houarizegai.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {
    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        // get the bean from the bean container
        SwimCoach myCoach = context.getBean("swimCoach", SwimCoach.class);

        // call a method on the bean
        System.out.println(myCoach.getDailyWorkout());

        // call method to get the daily fortune
        System.out.println(myCoach.getDailyFortune());

        System.out.println("email: " + myCoach.getEmail());
        System.out.println("team: " + myCoach.getTeam());

        // close the context
        context.close();
    }

}
