package com.houarizegai.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Order(-2)
public class LoggingAspect {

    @Before("execution(public void com.houarizegai.springaop.dao.UserRepository.save(com.houarizegai.springaop.model.User))")
    public void beforeAddUserArgumentAdvice(JoinPoint joinPoint) {
        // Display the method signature
        MethodSignature method = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + method);

        // Display the arguments
        Object[] args = joinPoint.getArgs();
        Arrays.stream(args).forEach(System.out::println);

        System.out.println("=====> User Aspect - @Before save(User) method in class inside dao package");
    }
}
