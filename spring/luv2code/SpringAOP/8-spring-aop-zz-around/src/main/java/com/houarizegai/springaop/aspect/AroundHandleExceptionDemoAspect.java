package com.houarizegai.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.logging.Logger;

@Aspect
@Component
public class AroundHandleExceptionDemoAspect {

    private static Logger logger = Logger.getLogger(AroundHandleExceptionDemoAspect.class.getName());

    // executed in both cases (success / failure), like: the finally block in Java
    @Around("execution(* com.houarizegai.springaop.dao.UserRepository.findAll())")
    public Object aroundFindAll(ProceedingJoinPoint proceedingJoinPoint) {
        logger.info("Around aspect: " + proceedingJoinPoint.getSignature().getDeclaringTypeName());

        try {
        return proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            logger.warning("Exception catched on Around find All");
            return Collections.emptyList();
        }

    }
}
