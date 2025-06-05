package com.jpractice.multithreading;

import java.util.concurrent.*;

public class CompletableFutureExample {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching data...");
            return 10;
        }).thenApply(data -> {
            System.out.println("Processing data...");
            return data * 2;
        }).thenAccept(result -> {
            System.out.println("Final Result: " + result);
        });

        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
    }
}
