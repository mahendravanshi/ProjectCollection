package com.example.aopDemo.services;

import org.springframework.stereotype.Service;

@Service
public class StudentService {


    public void saveStudent() {
        System.out.println("Student has been saved");
    }

    public void updateStudent(int id) {
        int num = 0/id;
        System.out.println("Student has been updated by Id "+num);
    }

    public void getStudent() {
        System.out.println("Student has been searched");
    }
}
