package com.houarizegai.springaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-2)
public class LoggingAspect {

    @Before("execution(public void com.houarizegai.springaop.dao.*.*(..))")
    public void beforeAddUserAdvice() {
        System.out.println("=====> User Aspect - @Before method in class inside dao package");
    }
}
