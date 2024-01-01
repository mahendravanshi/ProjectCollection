package com.optum.multithreading.runnableLambda.join.runnable;

public class Multithreading2 implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<=5;i++){
            System.out.println("Multithreading2");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }


}
