package com.optum.multithreading.multiple;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadExample {

    public static void main(String[] args) {
        // Number of threads you want to start
        int numberOfThreads = 5;

        // Create a thread pool with the desired number of threads
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);

//        int coreCount = Runtime.getRuntime().availableProcessors();
//        System.out.println("Core Count "+coreCount);
        // Create and start CompletableFuture for each thread
        CompletableFuture<?>[] futures = new CompletableFuture[numberOfThreads];

        for (int i=0;i<numberOfThreads;i++) {

            int threadNumber = i + 1;
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                // Code to be executed by each thread
                System.out.println("Thread " + threadNumber + " started at: " + System.currentTimeMillis());
                // Perform some work or task here
            }, executorService);

            futures[i] = future;
        }

        // Join all CompletableFuture instances to wait for all threads to complete
        CompletableFuture.allOf(futures).join();

        // Shutdown the executor service
        executorService.shutdown();
    }
}

