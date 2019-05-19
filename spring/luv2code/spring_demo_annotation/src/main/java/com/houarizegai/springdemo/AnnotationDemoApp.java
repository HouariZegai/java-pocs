package com.houarizegai.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		// read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the bean from the bean container
		Coach myCoach = context.getBean("tennisCoach", Coach.class);
		
		// call a method on the bean
		System.out.println(myCoach.getDailyWorkout());

		// call method to get the daily fortune
		System.out.println(myCoach.getDailyFortune());
		
		// close the context
		context.close();
	}

}
