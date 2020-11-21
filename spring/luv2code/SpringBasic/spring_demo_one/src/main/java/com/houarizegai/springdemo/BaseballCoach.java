package com.houarizegai.springdemo;

public class BaseballCoach implements Coach {

    private FortuneService fortuneService;
    private String name;

    public BaseballCoach() {

    }

    public BaseballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public void setName(String name) {
        System.out.println("setName called, value=" + name);
        this.name = name;
    }

    public FortuneService getFortuneService() {
        return fortuneService;
    }

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getDailyWorkout() {
        return "Spend 30 minutes on batting practice";
    }
}
