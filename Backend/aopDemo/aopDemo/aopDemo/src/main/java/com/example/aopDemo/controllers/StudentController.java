package com.example.aopDemo.controllers;

import com.example.aopDemo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@ControllerAdvice

public class StudentController {


    @Autowired
    private StudentService studentService;


    @GetMapping("/student")
    public void saveStudent() {

        studentService.saveStudent();
    }


    @GetMapping("/studentById/{id}")
    public void updateStudent(@PathVariable int id) {
        studentService.updateStudent(id);
    }

    @GetMapping("st")
    public void getStudent() {
        studentService.getStudent();
    }
}
