package com.fordTest1.DesignPatterns.common;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,8,7,6,5,4,3,2);

        System.out.println(list.stream().distinct().collect(Collectors.toList()));

        List<Integer> list1 = new ArrayList<>();
        for(int num:list){
            if(!list1.contains(num)){
                list1.add(num);
            }
        }

        System.out.println("List1 "+list1);


        System.out.println("'''''''''''''''''''''''''''''''");
        String s = "Aagggccsseegg";
        s.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).forEach((k,v)-> System.out.println("Key "+k+" Value "+v));

        System.out.println("'''''''''''''+++++++++++++++++++++++++++++++++++++++++++++++++++++++''''''''''''''''''");

        String s1 = "HI FordPro bYe FORDPRO goodbye FORDPRO welcome FORDPRO Hi There FordPro BYE bye FordPro";
        // Counting occurrences of each word
       Arrays.stream(s1.split(" "))
                .map(String::toUpperCase) // Convert to uppercase for case-insensitive counting
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).forEach((k,v)-> System.out.println(k+" "+v));;
//        System.out.println("Word count map "+wordCountMap);

       String reverseString =  Arrays.stream(s1.trim().split("\\s+")).reduce("",(a,b)->(b+" "+a)).toString();
        System.out.println("reversedString "+reverseString);


       



    }
}
