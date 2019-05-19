package com.houarizegai.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		// read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the bean from the bean container
		Coach myCoach = context.getBean("tennisCoach", Coach.class);
		
		System.out.println(myCoach.getDailyWorkout());

		// close the context
		context.close();
	}

}
