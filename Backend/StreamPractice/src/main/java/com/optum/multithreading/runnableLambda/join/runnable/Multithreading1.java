package com.optum.multithreading.runnableLambda.join.runnable;

public class Multithreading1 implements Runnable{


    @Override
    public void run() {
        for(int i=0;i<=5;i++){
            System.out.println("Multithreading1");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }




}
