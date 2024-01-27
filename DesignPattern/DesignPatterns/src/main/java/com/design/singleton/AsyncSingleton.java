package com.design.singleton;

import java.util.concurrent.CompletableFuture;

public class AsyncSingleton {

    private static CompletableFuture<AsyncSingleton> instance;

    private AsyncSingleton() {
        // Private constructor to prevent instantiation.
    }

    public static CompletableFuture<AsyncSingleton> getInstance() {
        if (instance == null) {
            synchronized (AsyncSingleton.class) {
                if (instance == null) {
                    instance = CompletableFuture.supplyAsync(() -> new AsyncSingleton());
                }
            }
        }
        return instance;
    }

    public void performAsyncOperation() {
        System.out.println("Asynchronous operation performed by the singleton instance.");
    }

    public static void main(String[] args) {
        CompletableFuture<AsyncSingleton> singletonFuture = AsyncSingleton.getInstance();

        singletonFuture.thenAccept(instance -> {
            instance.performAsyncOperation();
        });
    }


}

