package com.example.hotel.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(MyAspectBean.class);

    @AfterThrowing(pointcut = "userPointCut()")
    public void afterThrow(JoinPoint joinPoint){
        System.out.println("\n\n<-- after throw -->\n");
        logger.error("Exception in method: " + joinPoint.getSignature().getName());
        System.out.println("\n\n");
        //logger.error("Exception message: " + exception.getMessage());
        //logger.error("Stack trace:", exception);
    }
}
