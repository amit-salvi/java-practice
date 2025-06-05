package com.jpractice.multithreading;

import java.util.concurrent.CompletableFuture;

public class AsyncExample {
    public static void main(String[] args) {
        System.out.println("Main thread: " + Thread.currentThread().getName());

        CompletableFuture.supplyAsync(() -> {
            System.out.println("supplyAsync thread: " + Thread.currentThread().getName());
            sleep(3000); // simulate long task
            return 100;
        }).thenApply(result -> {
            System.out.println("thenApply thread: " + Thread.currentThread().getName());
            return result * 2;
        }).thenAccept(finalResult -> {
            System.out.println("Final result: " + finalResult);
            System.out.println("thenAccept thread: " + Thread.currentThread().getName());
        });

        System.out.println("Main thread continues...");
        sleep(5000); // prevent JVM exit
    }

    static void sleep(int ms) {
        try { Thread.sleep(ms); } catch (Exception ignored) {}
    }
}
