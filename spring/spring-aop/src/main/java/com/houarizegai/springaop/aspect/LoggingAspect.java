package com.houarizegai.springaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
//    @Before("execution(public void save())")
//    @Before("execution(public * sav*())")
    @Before("execution(public void com.houarizegai.springaop.dao.UserRepository.save())")
    public void beforeSaveUserAdvice() {
        System.out.println("Aspect - @Before save user advice");
    }
}
