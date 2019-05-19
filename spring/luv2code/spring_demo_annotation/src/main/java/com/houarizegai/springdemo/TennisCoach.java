package com.houarizegai.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach") // specify the id of bean
@Component // default bean id: take the name of class, make the first character lower case.
public class TennisCoach implements Coach {

	FortuneService fortuneService;
	
	public TennisCoach() {
		
	}
	
	/*	
    @Autowired
	public TennisCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
 	*/
	
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}
	
	/*
	@Autowired
	public void setDailyFortune(FortuneService fortuneService) {
		System.out.println("setDailyFortune() called !");
		this.fortuneService = fortuneService;
	}
	*/
	
	@Autowired
	public void doSomeCrazyStuff(FortuneService fortuneService) {
		System.out.println("doSomeCrazyStuff() called !");
		this.fortuneService = fortuneService;
	}
	
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
