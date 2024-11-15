package com.stream.modal;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Student implements Comparable<Student>{

     private Integer id;
     private String name;
     private Double mathMarks;
     private Double engMarks;
     private Double scienceMark;
    private String gender;

    @Override
     public int compareTo(Student other){

            if(this.getMathMarks()<other.getMathMarks()) return -1;
            else if(this.getMathMarks()>other.getMathMarks()) return 1;
            return 0;
     };


}
