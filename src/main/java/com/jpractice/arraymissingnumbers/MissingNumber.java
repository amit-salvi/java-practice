package com.jpractice.arraymissingnumbers;

public class MissingNumber {

    public static int findMissingNumber(int[] arr) {
        int n = arr.length; // one number is missing, so total count is n+1
        int expectedSum = (n * (n + 1)) / 2;
        int actualSum = 0;

        for (int i = 0; i < n; i++) {
            actualSum += arr[i];
        }

        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int[] input1 = {3, 0, 1};
        int[] input2 = {0, 1, 3, 4, 5};

        System.out.println("Missing number: " + findMissingNumber(input1)); // 2
        System.out.println("Missing number: " + findMissingNumber(input2)); // 2
    }
}
