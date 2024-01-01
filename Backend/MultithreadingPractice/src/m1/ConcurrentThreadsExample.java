package m1;


import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentThreadsExample {


    public static void main(String[] args) {
        // Create a fixed-size thread pool with 5 threads
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Create an array to store CompletableFuture instances
        CompletableFuture<Void>[] futures = new CompletableFuture[5];

        // Submit 5 tasks (runnables) to the thread pool using CompletableFuture
        for (int i = 0; i < 5; i++) {
            int threadNumber = i + 1;
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                // Code to be executed by the thread
                System.out.println("Thread " + threadNumber + " is running"+ LocalDateTime.now());
            }, executor);
            futures[i] = future;
        }

        // Wait for all CompletableFuture instances to complete
        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures);

        try {
            // Block until all threads are completed
            allOf.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Shutdown the executor when tasks are completed
        executor.shutdown();
    }
}
