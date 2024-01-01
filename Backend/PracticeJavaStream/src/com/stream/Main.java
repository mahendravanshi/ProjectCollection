package com.stream;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Employee emp1=new Employee(1,"abc");
        Employee emp2=new Employee(2,"def");
        Employee emp3=new Employee(3,"ghi");
        Employee emp4=new Employee(4,"jkl");
        Employee emp5=new Employee(1,"jkl");

        List<Employee> employees=new ArrayList<>();
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);
        employees.add(emp5);

        //Employee Details Sorted By name.

        List<Employee> sortedList = employees.stream().sorted((a,b)->a.getName().compareTo(b.getName())).collect(Collectors.toList());

        sortedList.forEach(System.out::println);



        //.Find unique name from list
        List<String> unikListy = employees.stream().collect(Collectors.groupingBy(e->e.getName(),Collectors.counting()))
                .entrySet().stream().filter(entry->entry.getValue()==1).map(entry->entry.getKey()).collect(Collectors.toList());


        Set<String> setUnik = employees.stream().map(x->x.getName()).collect(Collectors.toSet());



       List<Emp> emps =  Arrays.asList(
                new Emp(1, "IT", "John Doe"),
                new Emp(2, "HR", "Jane Smith"),
                new Emp(3, "Finance", "Alice Johnson"),
                new Emp(4, "Marketing", "Bob Williams"),
                new Emp(5, "IT", "Charlie Brown"),
                new Emp(6, "Finance", "David Lee"),
                new Emp(7, "Marketing", "Eva Davis"),
                new Emp(8, "HR", "Frank Miller"),
                new Emp(9, "IT", "Grace Taylor"),
                new Emp(10, "Finance", "Henry Wilson")
        );


       Map<String,List<Emp>> map = emps.stream().collect(Collectors.groupingBy(e->e.getDepartment()));


    }
}
