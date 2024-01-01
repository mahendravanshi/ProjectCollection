package com.optum.multithreading.runnableLambda.runnable;


import java.security.spec.RSAOtherPrimeInfo;

public class Main {

    public static void main(String[] args) throws Exception{

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
        Thread t2 = new Thread(m2);

        t1.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        t2.start();
        System.out.println(t1.isAlive());
        System.out.println(t2.isAlive());

        t1.join();
        t2.join();


        System.out.println(t1.isAlive());
        System.out.println(t2.isAlive());
        System.out.println("End of main");


    }
}
