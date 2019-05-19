package com.houarizegai.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		BaseballCoach theCoach = context.getBean("baseballCoach", BaseballCoach.class);
		System.out.println(theCoach.getFortuneService());
		
		context.close();
	}

}
