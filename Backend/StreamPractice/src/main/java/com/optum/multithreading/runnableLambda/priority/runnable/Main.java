package com.optum.multithreading.runnableLambda.priority.runnable;


public class Main {

    public static void main(String[] args) {

        Runnable m1 = () -> {
            for(int i=0;i<=5;i++){
                System.out.println("Multithreading1 "+Thread.currentThread().getPriority());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }

        };

        Runnable m2 = () -> {
            for(int i=0;i<=5;i++){
                System.out.println("Multithreading2 "+Thread.currentThread().getPriority());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        };


        Thread t1 = new Thread(m1);
        Thread t2 = new Thread(m2);
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.setName("Thread 1");
        t2.setName("Thread2");
        t1.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



        t2.setName("Thread 2");
        t2.start();

    }
}
