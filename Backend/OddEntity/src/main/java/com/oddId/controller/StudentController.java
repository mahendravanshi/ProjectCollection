package com.oddId.controller;


import com.oddId.entity.Student;
import com.oddId.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    StudentRepo studentRepo;

    @PostMapping("oddSave")
    public Student saveStudent(@RequestBody Student student){

        return studentRepo.save(student);
    }


}
