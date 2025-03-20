package com.example.service1.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("@annotation(com.example.service1.annotation.LogExecutionTime)") // all methods which are annotated with this annotation LogExecutionTime
    public Object logExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object proceed = proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();
        logger.info(proceedingJoinPoint.getSignature() + " executed in " + (endTime - startTime)/1000 + " seconds");
        return proceed;
    }
    @Before("execution(* com.example.service1.controller.EmployeeController.healthCheck())")
    public void beforeAdvice(){
        System.out.println("Entered executing healthcheck method");
    }
}
