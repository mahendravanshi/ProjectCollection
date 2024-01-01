package com.optum.stream;

import com.optum.stream.Building;
import com.optum.stream.Emp;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

       List<Emp> list = Arrays.asList(
                new Emp(1, "IT", "John Doe"),
                new Emp(1, "HR", "Jane Smith"),
                new Emp(3, "Finance", "Alice Johnson"),
                new Emp(4, "Marketing", "Bob Williams"),
                new Emp(5, "IT", "Charlie Brown"),
                new Emp(6, "Finance", "David Lee"),
                new Emp(7, "Marketing", "Eva Davis"),
                new Emp(8, "HR", "Frank Miller"),
                new Emp(9, "IT", "Grace Taylor"),
                new Emp(10, "Finance", "Henry Wilson")
       );

       // unique names
        Set<String> unikName = list.stream().map(e->e.getName()).collect(Collectors.toSet());

        unikName.forEach(System.out::println);


        // no of employees in each department
        list.stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.counting()))
                .forEach((k, v) -> System.out.println("Department " + k + " Count " + v));


        Map<String, List<String>> map = list.stream()
                .collect(Collectors.groupingBy(
                        Emp::getDepartment,
                        Collectors.mapping(Emp::getName, Collectors.toList())
                ));


//        map.forEach((k,v)->System.out.println("Department: "+k+"\n List of Employees: "+v));


        //sort by name using comparator
        Comparator<Emp> compName = (a,b)->{

              String x = a.getName();
              String y = b.getName();

              return x.compareTo(y);

        };


        Comparator<Emp> compId = (a,b)->{

            int x = a.getId();
            int y  = b.getId();

            if(x>y) return 1;
            else if(x<y) return -1;
            else return 0;

        };

        System.out.println("ById and name");
        list.stream().sorted(compId.thenComparing(compName)).forEach(System.out::println);



//        Find duplicate elements in array and then square them and add them using stream

        int[] arr = {1,2,3,4,5,5,5,6,6,7,7,8,8,9,9,1,0,1,1,1,12,13,14};
        int[] arr2 = {1,2,3,4,4};

        int sum1 = Arrays.stream(arr2).boxed().collect(Collectors.groupingBy(e->e,Collectors.counting())).entrySet()
                .stream().filter((entry->entry.getValue()>1)).mapToInt(entry->entry.getKey()*entry.getKey()).reduce(0,(acc,el)->acc+el);

        System.out.println(sum1);

//        /*.create hashmap add employee details on this.
        //8.find duplicate building in hashmap.*/


        List<Building> buildingList = new ArrayList<>();
        buildingList.add(new Building(1, "Office"));
        buildingList.add(new Building(2, "Residential"));
        buildingList.add(new Building(3, "Office"));
        buildingList.add(new Building(1, "Office")); // Duplicate
        buildingList.add(new Building(4, "Commercial"));
        buildingList.add(new Building(5, "Residential"));
        buildingList.add(new Building(4, "Commercial")); // Duplicate

        List<Building> dupBuildings = buildingList.stream().collect(Collectors.groupingBy((e->e),Collectors.counting()))
                .entrySet().stream().filter(entry->entry.getValue()>1).map(entry->entry.getKey()).collect(Collectors.toList());


        System.out.println(dupBuildings);




    }
}
