package com.prep.f1;

import java.util.stream.IntStream;

public class StringMethods {

    public static void main(String[] args) {
        String s1 = "    ";

        System.out.println(s1.isEmpty());


        IntStream.of(1, 2, 3, 5, 6, 7)
                .filter((var i) -> i % 2 == 0)
                .forEach(System.out::println);


    }



}
