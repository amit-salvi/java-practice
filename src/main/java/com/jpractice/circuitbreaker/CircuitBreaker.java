package com.jpractice.circuitbreaker;

import java.util.Deque;
import java.util.LinkedList;

public class CircuitBreaker {
    private final int failureThreshold = 3;
    private final long failureTimeWindowMillis = 10 * 60 * 1000; // 10 mins
    private final long cooldownMillis = 5 * 60 * 1000; // 5 mins

    private final Deque<Long> failureTimestamps = new LinkedList<>();
    private boolean circuitOpen = false;
    private long circuitOpenedAt = 0;

    public synchronized boolean allowRequest() {
        long now = System.currentTimeMillis();

        // Check if circuit is open and 5 mins have passed
        if (circuitOpen) {
            if (now - circuitOpenedAt >= cooldownMillis) {
                circuitOpen = false;
                failureTimestamps.clear();
                return true;
            } else {
                return false;
            }
        }

        // Remove old timestamps
        while (!failureTimestamps.isEmpty() && now - failureTimestamps.peekFirst() > failureTimeWindowMillis) {
            failureTimestamps.pollFirst();
        }

        return true;
    }

    public synchronized void recordFailure() {
        long now = System.currentTimeMillis();
        failureTimestamps.addLast(now);

        // Clean old timestamps
        while (!failureTimestamps.isEmpty() && ((now - failureTimestamps.peekFirst()) > failureTimeWindowMillis)) {
            failureTimestamps.pollFirst();
        }

        if (failureTimestamps.size() >= failureThreshold) {
            circuitOpen = true;
            circuitOpenedAt = now;
        }
    }
}
