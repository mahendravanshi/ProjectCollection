package com.thread.Multithreading1.thread;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        int n = 10;
//        for(int i=0;i<1000;i++){
//
//             Multithread1 m1 = new Multithread1();
//
//             m1.run();
//             System.out.println(LocalDateTime.now());
//        }

//        for(int i=0;i<1000;i++){
//
//            Thread t1 = new Thread(new Multithread2());
//
//            t1.run();
//            System.out.println(LocalDateTime.now());
//        }

        // Create a fixed-size thread pool with 5 threads
        ExecutorService pool = Executors.newFixedThreadPool(50);

        // Submit tasks to the thread pool
        for (int i = 0; i < 10; i++) {
            final int taskNumber = i;
            pool.submit(() -> {
                System.out.println("Task " + taskNumber + " executed by thread: " + Thread.currentThread().getName());
                // Code to be executed in the thread
            });
        }


        // Shutdown the pool after tasks are submitted
        pool.shutdown();


    }
}
