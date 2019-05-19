package com.houarizegai.springdemo;

import org.springframework.stereotype.Component;

@Component
public class FortuneServiceRandom implements FortuneService {

	public String getFortune() {
		return "get Random service";
	}

}
