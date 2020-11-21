package com.houarizegai.springaop.aspect;

import com.houarizegai.springaop.model.User;
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
        System.out.println("=====> Aspect - @Before save user advice");
    }

    @Before("execution(void com.houarizegai.springaop.service.*.*(..))")
    public void beforeServicePackage() {
        System.out.println("=====> Aspect - before any method in service package");
    }

    @Before("execution(void com.houarizegai.springaop.service.*.*(com.houarizegai.springaop.model.User, ..))")
    public void beforeServicePackageWithArgument() {
        System.out.println("=====> Aspect - before any method in service package with User as argument");
    }
}
