package com.houarizegai.springdemo;

public class SwimCoach implements Coach {

	private FortuneService fortuneService;
	
	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	public String getDailyWorkout() {
		return "Swim 1000 meters as a warm up.";
	}

	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
}
