package com.houarizegai.springdemo;

import org.springframework.stereotype.Component;

//@Component("thatSillyCoach") // specify the id of bean
@Component // default bean id: take the name of class, make the first character lower case.
public class TennisCoach implements Coach {

	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}
	
}
