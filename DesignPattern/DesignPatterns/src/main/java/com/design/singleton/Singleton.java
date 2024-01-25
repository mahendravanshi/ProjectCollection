package com.design.singleton;


import lombok.EqualsAndHashCode;


public class Singleton {

    private static Singleton singleton;

    private Singleton(){

    }

    public static Singleton getInstance(){

           if(singleton!=null){
               return singleton;
           }

           return singleton = new Singleton();
    }





}
