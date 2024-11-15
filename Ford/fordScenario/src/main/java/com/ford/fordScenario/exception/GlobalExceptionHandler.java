package com.ford.fordScenario.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

       @ExceptionHandler(VehicleRegisterException.class)
       public ProblemDetail vehicleIsnull(VehicleRegisterException ve){

           return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,ve.getMessage());
       }
}
