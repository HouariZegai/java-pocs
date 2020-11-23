package com.houarizegai.springaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyCloudLogAspect {

    @Before("execution(public void com.houarizegai.springaop.dao.*.*(..))")
    public void logToCloudAsyncAdvice() {
        System.out.println("=====> Cloud Aspect - @Before method in class inside dao package");
    }
}
