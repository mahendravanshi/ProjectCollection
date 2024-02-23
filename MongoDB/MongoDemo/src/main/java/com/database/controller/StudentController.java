package com.database.controller;

import com.database.model.Student;
import com.database.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

     @Autowired
     private StudentRepository studentRepository;

      @PostMapping("/students")
      public ResponseEntity<Student> addStudent(@RequestBody Student student){

           return new ResponseEntity<>(studentRepository.save(student), HttpStatus.OK);

      }

      @GetMapping("students/id")
     public ResponseEntity<Student> getStudentById(@PathVariable Integer id){
          return new ResponseEntity<>(studentRepository.findById(id).orElse(null), HttpStatus.OK);
      }


    @GetMapping("students")
    public ResponseEntity<List<Student>> getAllStudents(){
        return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);
    }





}
