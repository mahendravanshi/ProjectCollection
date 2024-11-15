package com.stream.modal;

import com.stream.modal.Student;

import java.util.*;
import java.util.stream.Collectors;

public class StudentMain {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                Student.builder().id(1).name("Alice").mathMarks(80.0).engMarks(75.0).scienceMark(85.0).gender("female").build(),
                Student.builder().id(2).name("Bob").mathMarks(65.0).engMarks(70.0).scienceMark(75.0).gender("male").build(),
                Student.builder().id(3).name("Carol").mathMarks(90.0).engMarks(85.0).scienceMark(95.0).gender("female").build(),
                Student.builder().id(4).name("Dave").mathMarks(85.0).engMarks(80.0).scienceMark(90.0).gender("male").build(),
                Student.builder().id(5).name("Eve").mathMarks(70.0).engMarks(65.0).scienceMark(75.0).gender("female").build(),
                Student.builder().id(6).name("Frank").mathMarks(60.0).engMarks(55.0).scienceMark(65.0).gender("male").build()
        );

        //Student highest marks total
        Optional<Student> highestMarkTotal = students.stream()
                .max(Comparator.comparingDouble(s -> s.getEngMarks() + s.getMathMarks() + s.getScienceMark()));

//        highestMarkTotal.ifPresent(s-> System.out.println(
//                s +" totalMarks: "+(s.getMathMarks()+s.getEngMarks()+s.getScienceMark())
//        ));

        // give student with highest marks in Maths
        Optional<Student> highestMaths = students.stream().sorted((s1,s2)->Double.compare(s2.getMathMarks(),s1.getMathMarks())).findFirst();

//        highestMaths.ifPresent(s-> System.out.println(s));

        //Given a list of Student objects, filter out students who have passed (where passing criteria is mathMarks >= 60 && engMarks >= 60 && scienceMark >= 60). Then, map their names to uppercase.
//        students.stream().filter(s->{
//            return s.getMathMarks() >= 60 && s.getEngMarks() >= 60 && s.getScienceMark() >= 60;
//
//        }).map(Student::getName).forEach(System.out::println);

        // Create a stream of Student objects, sort them by their total marks (sum of mathMarks, engMarks, and scienceMark) in descending order, and then limit the stream to the top 3 students.


        Comparator<Student> compTotal  = (a,b)->{

            double x = a.getEngMarks()+a.getScienceMark()+a.getMathMarks();
            double y = b.getEngMarks()+b.getMathMarks()+b.getScienceMark();

            return x>y?-1:x<y?1:0;
        };
//        students.stream().sorted((a, b) -> {
//            double x = a.getEngMarks() + a.getScienceMark() + a.getMathMarks();
//            double y = b.getEngMarks() + b.getMathMarks() + b.getScienceMark();
//            return x>y?-1:x<y?1:0; // Compare in descending order
//        }).limit(3).forEach(System.out::println);

//Given a list of Student objects, group students by their grade (e.g., A if average marks >= 90, B if average marks >= 80, etc.) and count the number of students in each grade category.

//         students.stream().collect(Collectors.groupingBy(s->{
//             double avgMarks = (s.getEngMarks() + s.getMathMarks() + s.getScienceMark())/3.0;
//
//             if (avgMarks >= 90) {
//                 return "A";
//             } else if (avgMarks >= 80) {
//                 return "B";
//             } else if (avgMarks >= 70) {
//                 return "C";
//             } else if (avgMarks >= 60) {
//                 return "D";
//             } else {
//                 return "F";
//             }
//         },Collectors.counting())).forEach((k,v)-> System.out.println("Grade: "+ k+" "+"totalStudents "+v));

        // Compute the average marks (math, english, and science combined) of all students in the list.

        double avgMarks = students.stream().mapToDouble(s->s.getEngMarks() + s.getMathMarks() + s.getScienceMark())
                .average().orElse(0.0);

//        System.out.println(avgMarks/3.0);

        //Given a list of Student objects, filter out students who have scored less than 70 marks in any subject, map their names to uppercase, and collect them into a Set.

        Set<String> set =  students.stream().filter(s->(s.getScienceMark()>=70 && s.getEngMarks()>=70 && s.getMathMarks()>=70)).map(s->s.getName().toUpperCase()).collect(Collectors.toSet());
//        System.out.println(set);

        //Perform a custom operation using the Stream API, such as calculating the difference in average marks between male and female students, given a list of Student objects with a gender field.
        OptionalDouble fmAvg = students.stream().filter(s->"female".equalsIgnoreCase(s.getGender())).mapToDouble(s->(s.getEngMarks()+s.getScienceMark()+s.getMathMarks())).average();
        OptionalDouble mAvg = students.stream().filter(s->"male".equalsIgnoreCase(s.getGender())).mapToDouble(s->(s.getEngMarks()+s.getScienceMark()+s.getMathMarks())).average();

//        if(fmAvg.isPresent()&&mAvg.isPresent()){
//            double diff = fmAvg.getAsDouble()-mAvg.getAsDouble();
//            System.out.println(diff);
//        }
//        else{
//            System.out.println("Data mismatch");
//        }

        // Group by gender

        var x = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGender,
                        Collectors.maxBy(Comparator.comparingDouble(Student::getEngMarks))));

//         x.forEach((gender,student)->{
//             System.out.println("Gender: "+gender);
//             student.ifPresent(System.out::println);
//         });

         // get by gender and ascending by marks total
         students.stream().sorted((s1,s2)->Double.compare(s1.getEngMarks()+s1.getScienceMark()+s1.getMathMarks(),s2.getScienceMark()+s2.getEngMarks()+s2.getMathMarks())).collect(Collectors.groupingBy(Student::getGender)).forEach((gender,student)->{
             System.out.println("Gender: "+gender);
             System.out.println(student);
         });
//        y.forEach((gender,student)->{
//             System.out.println("Gender: "+gender);
//            System.out.println(student);
//         });



    }
}

