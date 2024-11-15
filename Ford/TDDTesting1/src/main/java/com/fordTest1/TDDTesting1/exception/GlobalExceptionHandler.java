package com.fordTest1.TDDTesting1.exception;


import jakarta.annotation.Resource;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

      @ExceptionHandler(RuntimeException.class)
     public ProblemDetail genericException(RuntimeException re){

          return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,re.getMessage());
      }

      @ExceptionHandler(CustomException.class)
      public ProblemDetail customException(CustomException ce){
         ProblemDetail pd =   ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,ce.getMessage());

         pd.setProperty("timeStamp", LocalDateTime.now());
         pd.setTitle("Title "+ce.getMessage());
         return pd;


      }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String,Object>> resourceNotFoundException(ResourceNotFoundException rnf){
          Map<String,Object> map = new HashMap<>();
          map.put("error",rnf.getMessage());
          map.put("timeStamp", LocalDateTime.now().toString());
          return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);

    }



}
