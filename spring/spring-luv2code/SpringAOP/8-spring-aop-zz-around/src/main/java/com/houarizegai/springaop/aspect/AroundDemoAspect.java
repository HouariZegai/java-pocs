package com.houarizegai.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AroundDemoAspect {

    // executed in both cases (success / failure), like: the finally block in Java
    @Around("execution(* com.houarizegai.springaop.dao.UserRepository.findAll())")
    public Object aroundFindAll(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("=====> Around aspect: " + proceedingJoinPoint.getSignature().getDeclaringTypeName());

        long begin = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        long duration = System.currentTimeMillis() - begin;
        System.out.printf("findAll execution Duration: %.2f seconds\n", duration / 1000d);

        return result;
    }
}
