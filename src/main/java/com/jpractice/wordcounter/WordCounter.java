package com.jpractice.wordcounter;

public class WordCounter {

    public static int[] countWordOccurrences(String[] paragraphs, String word) {
        int[] result = new int[paragraphs.length];
        String target = word.toLowerCase();

        for (int i = 0; i < paragraphs.length; i++) {
            String[] tokens = paragraphs[i].toLowerCase().split("\\W+"); // split by non-word characters
            int count = 0;
            for (int j = 0; j < tokens.length; j++) {
                if (tokens[j].equals(target)) {
                    count++;
                }
            }
            result[i] = count;
        }

        return result;
    }

    public static void main(String[] args) {
        String[] paragraphs = {
            "The quick brown fox jumps over the lazy dog.",
            "There is nothing either good or bad, but thinking makes it so.",
            "To be, or not to be, that is the question."
        };
        String word = "the";

        int[] counts = countWordOccurrences(paragraphs, word);

        for (int i = 0; i < counts.length; i++) {
            System.out.println("Paragraph " + (i + 1) + ": " + counts[i]);
        }
    }
}
