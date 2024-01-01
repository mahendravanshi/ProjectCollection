package com.optum.multithreading.runnable;



public class Main {

    public static void main(String[] args) {

        Runnable m1 = new Multithreading1();
        Runnable m2 = new Multithreading2();

        Thread t1 = new Thread(m1);
        Thread t2 = new Thread(m2);
        t1.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t2.start();
    }
}
