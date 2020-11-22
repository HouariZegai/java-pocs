package com.houarizegai.springaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(public void com.houarizegai.springaop.dao.*.*(..))")
    public void beforeAddUserAdvice() {
        System.out.println("=====> Aspect - @Before method in class inside dao package");
    }

    @Before("execution(public void com.houarizegai.springaop.dao.*.*(..))")
    public void  xxAdvice() {
        System.out.println("=====> Aspect - @Before method in class inside dao package");
    }

    @Before("execution(public void com.houarizegai.springaop.dao.*.*(..))")
    public void logToCloudAsyncAdvice() {
        System.out.println("=====> Aspect - @Before method in class inside dao package");
    }
}
