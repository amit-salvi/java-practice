package com.jpractice.multithreading;

import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Integer> task = () -> {
            Thread.sleep(500);
            return 42;
        };

        Future<Integer> result = executor.submit(task);

        System.out.println("Doing other work...");
        System.out.println("Result: " + result.get());

        executor.shutdown();
    }
}
