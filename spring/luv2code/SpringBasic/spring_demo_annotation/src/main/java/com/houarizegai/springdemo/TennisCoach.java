package com.houarizegai.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component("thatSillyCoach") // specify the id of bean
@Component // default bean id: take the name of class, make the first character lower case.
//@Scope("prototype")
public class TennisCoach implements Coach {
    // field injection using java technology called Reflection
    @Autowired
    @Qualifier("fortuneServiceHappy") // specify the injection class (if there is multiple class inherit FortuneService interface) 
            FortuneService fortuneService;

    public TennisCoach() {

    }
	
	/*// constructor injection
    @Autowired
	public TennisCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
 	*/

    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }
	
	/*// setter injection
	@Autowired
	public void setDailyFortune(FortuneService fortuneService) {
		System.out.println("setDailyFortune() called !");
		this.fortuneService = fortuneService;
	}
	*/
	
	/*
	@Autowired
	public void doSomeCrazyStuff(FortuneService fortuneService) {
		System.out.println("doSomeCrazyStuff() called !");
		this.fortuneService = fortuneService;
	}
	*/

    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    // my init method
    @PostConstruct
    public void init() {
        System.out.println(">> TennisCoach: inside init()");
    }

    // my destroy method
    @PreDestroy
    public void destroy() {
        System.out.println(">> TennisCoach: inside destroy()");
    }

}
