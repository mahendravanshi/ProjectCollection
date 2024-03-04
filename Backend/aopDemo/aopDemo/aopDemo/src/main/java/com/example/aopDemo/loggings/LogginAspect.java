package com.example.aopDemo.loggings;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogginAspect {


    @Before("execution(* com.example.aopDemo.services.StudentService.saveStudent(..))")
    public void saveAdvice() {
        System.out.println("save method called");
    }



    @AfterReturning(pointcut = "execution(* com.example.aopDemo.services.StudentService.updateStudent(..))",returning = "result")
    public void updateAdvice() {
        System.out.println("update method called");
    }

    @AfterThrowing(pointcut = "execution(* com.example.aopDemo.services.StudentService.updateStudent(..))",throwing = "exception")
    public void updateAdviceException(Exception exception) {
        System.out.println("update method called and got a Exception"+exception.getMessage());
    }

    @Around("execution(* com.example.aopDemo.services.StudentService.getStudent(..))")
    public void aroundAdvice() {
        System.out.println("For get student details perform around operations");
    }

}
