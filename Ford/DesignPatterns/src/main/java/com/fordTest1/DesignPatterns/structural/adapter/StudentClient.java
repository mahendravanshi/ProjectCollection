package com.fordTest1.DesignPatterns.structural.adapter;

import java.util.ArrayList;
import java.util.List;

public class StudentClient {

      public List<Student> getStudentsList(){
          List<Student> students = new ArrayList<>();

          CollegeStudent collegeStudent = new CollegeStudent("ABC","BCD","abc@gmail.com");
          SchoolStudent schoolStudent = new SchoolStudent("CDE","DEF","cde@gmail.com");

          SchoolStudentAdapter schoolStudentAdapter = new SchoolStudentAdapter(schoolStudent);

          students.add(collegeStudent);
          return students;

      }
}
