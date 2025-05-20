package com.jpractice.arraymissingnumbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MissingNumberWithDuplicates {

    public static int findMissingNumber(int[] arr) {
        int n = arr.length; // One number is missing, but we may have duplicates
        boolean[] seen = new boolean[n + 1]; // range is 0 to n inclusive

        for (int i = 0; i < n; i++) {
            int value = arr[i];
            if (value >= 0 && value <= n) {
                seen[value] = true; // mark the number as seen
            }
        }

        // find the missing one
        for (int i = 0; i <= n; i++) {
            if (!seen[i]) {
                return i;
            }
        }

        // Ideally should never reach here if input has exactly one missing
        return -1;
    }

    public static void main(String[] args) {
        int[] input1 = {10, 11, 13, 13, 14};
        int[] input2 = {1, 1, 2, 3, 5};
        int[] input3 = {1, 2, 3, 4, 4};

        System.out.println("Missing number: " + findMissingNumber(input1)); // 3
        System.out.println("Missing number: " + findMissingNumber(input2)); // 0
        System.out.println("Missing number: " + findMissingNumber(input3)); // 0
    }
}
