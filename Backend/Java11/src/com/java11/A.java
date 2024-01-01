package com.java11;

import java.util.function.BiFunction;

public class A {


    public static void main(String[] args) {

        BiFunction<Integer,Integer,Integer> bi = (var a,var b)-> a+b;
       Integer x =  bi.apply(10,20);
        System.out.println(x);



    }
}
