package com.jpractice.arraymissingnumbers;

public class MissingNumberInAnyRange {

    public static int findMissingNumber(int[] arr) {
        int min = arr[0], max = arr[0];

        // Step 1: Find min and max
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int range = (max - min) + 1;

        // Step 2: Track unique values using a boolean array
        boolean[] seen = new boolean[range];

        for (int i = 0; i < arr.length; i++) {
            int idx = arr[i] - min;
            if (idx >= 0 && idx < range) {
                seen[idx] = true;
            }
        }

        // Step 3: Find the number not marked
        for (int i = 0; i < range; i++) {
            if (!seen[i]) {
                return min + i;
            }
        }

        return -1; // No missing number found
    }

    public static void main(String[] args) {
        int[] input1 = {10, 11, 13, 13, 14};
        int[] input2 = {101, 104, 103, 101, 102}; // Missing 100
        int[] input3 = {50, 52, 53, 50}; // Missing 51

        System.out.println("Missing: " + findMissingNumber(input1)); // 12
        System.out.println("Missing: " + findMissingNumber(input2)); // 100
        System.out.println("Missing: " + findMissingNumber(input3)); // 51
    }
}
