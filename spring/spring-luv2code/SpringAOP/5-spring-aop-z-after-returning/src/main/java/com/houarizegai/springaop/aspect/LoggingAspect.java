package com.houarizegai.springaop.aspect;

import com.houarizegai.springaop.model.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Aspect
@Component
@Order(-2)
public class LoggingAspect {

    @AfterReturning(pointcut = "execution(* com.houarizegai.springaop.dao.UserRepository.findAll())", returning = "users")
    public void afterReturningFindAll(JoinPoint joinPoint, List<User> users) {
        System.out.println("=====> After returning aspect: UserDao.findAll()");
        System.out.println("Returning Data:");
        users.forEach(System.out::println);

        System.out.println("Method signature; " + joinPoint.getSignature().toShortString());

        // Post process (modify the data before returning)

//        users.stream().peek(user -> user.setName("Fake name"))
//                .collect(Collectors.toList());

        users.stream().peek(user -> user.setName(user.getName().toUpperCase()))
                .collect(Collectors.toList());
    }
}
