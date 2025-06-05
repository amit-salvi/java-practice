package com.jpractice.multithreading;

public class HelloThread extends Thread {
    public void run() {
        System.out.println("Hello from " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        HelloThread t1 = new HelloThread();
        HelloThread t2 = new HelloThread();
        t1.start();
        t2.start();
    }
}
