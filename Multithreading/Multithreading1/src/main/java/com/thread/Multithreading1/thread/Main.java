package com.thread.Multithreading1.thread;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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


        Thread1 t1 = new Thread1();
//        t1.start();




//        List<Character> ch = Arrays.asList(
//                'G', 'e', 'e', 'k', 's', 'f', 'o', 'r', 'G',
//                'e', 'e', 'k', 's');
//
//        String str = ch.stream().map(String::valueOf).collect(Collectors.joining());
//        System.out.println(str);

        List<String> str_0 = Arrays.asList("Geeks", "for", "Geeks");
        String str1 = str_0.stream().collect(Collectors.joining());
//        System.out.println(str1);

        List<Character> ch = Arrays.asList('G', 'e', 'e', 'k', 's', 'f',
                'o', 'r', 'G', 'e', 'e', 'k', 's');

        // Convert the character list into String
        // using Collectors.joining() method
        // with, as the delimiter

//        String str3 = ch.stream().map(String::valueOf).collect(Collectors.joining(":"));
//        System.out.println(str3);


        // Get the List
        List<String> g
                = Arrays.asList("geeks", "for", "geeks");

        // Collect the list as map
        // by groupingBy() method
        Map<String, Long> result
                = g.stream().collect(
                Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()));


        // Print the result
        System.out.println(result);




    }
}
