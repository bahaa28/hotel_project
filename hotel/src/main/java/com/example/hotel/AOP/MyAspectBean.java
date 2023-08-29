package com.example.hotel.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class MyAspectBean {
    @Pointcut("execution(* com.example.hotel.controllers.UserEntityController.*(..))")
    private void userPointCut(){}

    @Before("userPointCut()")
    public void before(JoinPoint joinPoint){
        System.out.println("<<--before \n" + joinPoint.getSignature() + "\n started at " + new Date());
    }

    @After("userPointCut()")
    public void after(JoinPoint joinPoint){
        System.out.println("\n end at " + new Date() + "\nafter-->>");
    }

    @AfterThrowing("userPointCut()")
    public void afterThrow(JoinPoint joinPoint){
        System.out.println("\n\n<-- after throw -->\n");
    }
}
