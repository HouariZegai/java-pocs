package com.houarizegai.springaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(public void com.houarizegai.springaop.dao.*.*(..))")
    public void forDaoPackage() {
    }

    @Pointcut("execution(* com.houarizegai.springaop.model.*.*(..))")
    public void forModelPackage() {
    }

    @Pointcut("execution(* com.houarizegai.springaop.model.*.set*(..))")
    private void setter() {
    }

    @Pointcut("execution(* com.houarizegai.springaop.model.*.get*(..))")
    private void getter() {
    }

    @Pointcut("forModelPackage() && !(getter() || setter())")
    public void forModelPackageNoGetterSetter() {
    }

    // Important: work only with spring components
    @Before("forModelPackageNoGetterSetter()")
    public void modelPackageNoGetterSetter() {
        System.out.println("=====> Aspect - @Before method in class inside model package expect setter & getter");
    }

    @Before("forDaoPackage()")
    public void beforeSaveUserAdvice() {
        System.out.println("=====> Aspect - @Before method in class inside dao package");
    }
}
