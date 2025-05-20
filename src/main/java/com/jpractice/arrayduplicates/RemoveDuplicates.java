package com.jpractice.arrayduplicates;

public class RemoveDuplicates {

    public static int[] removeDuplicates(int[] input) {
        int n = input.length;
        int[] temp = new int[n]; // to store unique elements
        int count = 0; // number of unique elements

        for (int i = 0; i < n; i++) {
            boolean isDuplicate = false;

            // check if input[i] already appeared in temp
            for (int j = 0; j < count; j++) {
                if (input[i] == temp[j]) {
                    isDuplicate = true;
                    break;
                }
            }

            // if not a duplicate, add to temp
            if (!isDuplicate) {
                temp[count++] = input[i];
            }
        }

        // Copy only unique elements to a new array of correct size
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = temp[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input = {0, 2, 0, 3, 2, 5, 3, 6, 7, 5};
        int[] output = removeDuplicates(input);

        System.out.print("Unique values: ");
        for (int val : output) {
            System.out.print(val + " ");
        }
    }
}
