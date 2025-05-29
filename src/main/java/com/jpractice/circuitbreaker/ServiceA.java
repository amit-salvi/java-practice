package com.jpractice.circuitbreaker;

public class ServiceA {

    private final CircuitBreaker breakerB = new CircuitBreaker();
    private final CircuitBreaker breakerC = new CircuitBreaker();

    public String callServiceB() {
        if (!breakerB.allowRequest()) {
            return "Service B is inaccessible. Calls will be tried again in 5 mins.";
        }

        try {
            // simulate call
            simulateRemoteCall("B");
            return "Service B responded OK";
        } catch (Exception e) {
            breakerB.recordFailure();
            return "Service B failed: " + e.getMessage();
        }
    }

    public String callServiceC() {
        if (!breakerC.allowRequest()) {
            return "Service C is inaccessible. Calls will be tried again in 5 mins.";
        }

        try {
            // simulate call
            simulateRemoteCall("C");
            return "Service C responded OK";
        } catch (Exception e) {
            breakerC.recordFailure();
            return "Service C failed: " + e.getMessage();
        }
    }

    private void simulateRemoteCall(String service) throws Exception {
        // randomly throw error 30% of the time
        if (Math.random() < 0.3) {
            throw new Exception(service + " unreachable");
        }
    }
}
