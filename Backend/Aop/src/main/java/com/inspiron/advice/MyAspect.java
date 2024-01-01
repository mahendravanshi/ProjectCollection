package com.inspiron.advice;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Before("execution(* com.inspiron.services.PaymentServiceImpl.makePayment(..))")
    public void beforePayment(){

        System.out.println("Payment Started...");
    }

    @After("execution(* com.inspiron.services.PaymentServiceImpl.makePayment(..))")
    public void afterPayment(){
        System.out.println("Payment completed.");
    }

    @AfterThrowing(pointcut = "execution(* com.inspiron.services.PaymentServiceImpl.divideNumbers(..))",throwing ="ex")
    public void afterThrowing(Exception ex){

        System.out.println("Exception caught in aspect "+ex.getMessage());

    }


    @AfterReturning(pointcut = "execution(* com.inspiron.services.PaymentServiceImpl.divideNumbers())",returning ="obj")
    public void afterReturning(Object obj){
        System.out.println("Object returned "+obj);
    }


    @Around("execution(* com.inspiron.services.PaymentServiceImpl.proceedPayment(..))")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        // Code to be executed before the method
        Object result = null;
//        Object result = joinPoint.proceed(); // Proceed to the method
        // Code to be executed after the method
        System.out.println("around working "+result);
    }

}
