package com.optum.multithreading.extend;

public class Multithreading2 extends Thread{

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
