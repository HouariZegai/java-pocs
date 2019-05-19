package com.houarizegai.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach") // specify the id of bean
@Component // default bean id: take the name of class, make the first character lower case.
public class TennisCoach implements Coach {

	FortuneService fortuneService;
	
	@Autowired
	public TennisCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}
	
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
}
