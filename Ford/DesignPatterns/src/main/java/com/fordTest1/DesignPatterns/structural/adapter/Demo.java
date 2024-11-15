package com.fordTest1.DesignPatterns.structural.adapter;

import com.fordTest1.DesignPatterns.structural.adapter.Student;
import com.fordTest1.DesignPatterns.structural.adapter.StudentClient;

import java.util.List;

public class Demo {

    public static void main(String[] args) {

        StudentClient schoolClient = new StudentClient();

        List<Student> list = schoolClient.getStudentsList();

        System.out.println(list);

    }

}
