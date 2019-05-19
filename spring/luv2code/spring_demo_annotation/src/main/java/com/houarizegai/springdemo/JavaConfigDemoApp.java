package com.houarizegai.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {
	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from the bean container
		Coach myCoach = context.getBean("swimCoach", Coach.class);

		// call a method on the bean
		System.out.println(myCoach.getDailyWorkout());

		// call method to get the daily fortune
		System.out.println(myCoach.getDailyFortune());
		
		// close the context
		context.close();
	}

}
