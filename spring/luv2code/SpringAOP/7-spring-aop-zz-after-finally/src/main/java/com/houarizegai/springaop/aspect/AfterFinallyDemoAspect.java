package com.houarizegai.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterFinallyDemoAspect {

    // executed in both cases (success / failure), like: the finally block in Java
    @After("execution(* com.houarizegai.springaop.dao.UserRepository.findAll())")
    public void afterFinallyFindAll(JoinPoint joinPoint) {
        System.out.println("=====> After aspect: " + joinPoint.getSignature().getDeclaringTypeName());
    }
}
