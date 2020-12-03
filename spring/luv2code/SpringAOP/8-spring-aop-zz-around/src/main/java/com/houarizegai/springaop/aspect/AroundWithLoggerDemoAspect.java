package com.houarizegai.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class AroundWithLoggerDemoAspect {

    private static Logger logger = Logger.getLogger(AroundWithLoggerDemoAspect.class.getName());

    // executed in both cases (success / failure), like: the finally block in Java
    @Around("execution(* com.houarizegai.springaop.dao.UserRepository.findAll())")
    public Object aroundFindAll(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("Around aspect: " + proceedingJoinPoint.getSignature().getDeclaringTypeName());

        long begin = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        long duration = System.currentTimeMillis() - begin;
        logger.info(String.format("findAll execution Duration: %.2f seconds\n", duration / 1000d));

        return result;
    }
}
