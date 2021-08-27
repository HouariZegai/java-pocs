package com.houarizegai.springaop.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-2)
public class AfterThrowingDemoAspect {

    @AfterThrowing(pointcut = "execution(* com.houarizegai.springaop.dao.UserRepository.findAll())", throwing = "exception")
    public void afterThrowingFindAll(Throwable exception) {
        System.out.println("=====> After throwing aspect: UserDao.findAll()");
        System.out.println("Exception: " + exception);

    }
}
