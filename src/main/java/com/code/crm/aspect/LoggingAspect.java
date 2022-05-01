package com.code.crm.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    // setup logger
    private Logger logger = Logger.getLogger(getClass().getName());

    // setup pointcut declaration
    @Pointcut("execution(* com.code.crm.controller.*.*(..))")
    private void forControllerPackage() {
    }

    @Pointcut("execution(* com.code.crm.dao.*.*(..))")
    private void forDaoPackage() {
    }

    @Pointcut("execution(* com.code.crm.service.*.*(..))")
    private void forSericePackage() {
    }

    @Pointcut("forControllerPackage() || forDaoPackage() || forSericePackage()")
    private void forAppFlow() {
    }

    // add @Before advice
    @Before("forAppFlow()")
    public void beforeAppFlow(JoinPoint joinPoint) {

        // display method being called
        String method = joinPoint.getSignature().toShortString();
        logger.info("===> in @Before: calling method: " + method);

        // display arguments to the method
        Object[] args = joinPoint.getArgs();

        for (Object object : args) {
            logger.info("===> arguments: " + object.toString());
        }
    }

    // add @AfterReturning advice
    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    public void afterReturningAppFlow(JoinPoint joinPoint, Object result) {
        // display method being called
        String method = joinPoint.getSignature().toShortString();
        logger.info("===> after @AfterReturning: calling method: " + method);

        // display result from the method
        logger.info("===> arguments: " + result.toString());
    }
}
