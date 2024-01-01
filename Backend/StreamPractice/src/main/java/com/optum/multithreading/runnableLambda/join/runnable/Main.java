package com.optum.multithreading.runnableLambda.join.runnable;


public class Main {

    public static void main(String[] args) {

        Runnable m1 = () -> {
            for(int i=0;i<=5;i++){
                System.out.println("Multithreading1");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }

        };

        Runnable m2 = () -> {
            for(int i=0;i<=5;i++){
                System.out.println("Multithreading2");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        };


        Thread t1 = new Thread(m1);

        t1.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Thread t2 = new Thread(m2);
        t2.start();


    }
}
