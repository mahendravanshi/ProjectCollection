package com.optum.multithreading.extend;

public class Main {

    public static void main(String[] args) {

        Multithreading1 m1 = new Multithreading1();
        Multithreading2 m2 = new Multithreading2();

        m1.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        m2.start();
        
    }
}
