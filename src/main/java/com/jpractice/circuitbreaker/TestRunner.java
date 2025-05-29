package com.jpractice.circuitbreaker;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        ServiceA serviceA = new ServiceA();

        for (int i = 0; i < 20; i++) {
            System.out.println("B: " + serviceA.callServiceB());
            System.out.println("C: " + serviceA.callServiceC());
            Thread.sleep(1000); // simulate some delay between calls
        }
    }
}
