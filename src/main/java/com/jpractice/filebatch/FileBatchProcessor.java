package com.jpractice.filebatch;

import java.io.*;
import java.util.*;

public class FileBatchProcessor {

    private static final int BATCH_SIZE = 1000;

    public static void processLargeFile(String filePath) {
        List<String> batch = new ArrayList<>(BATCH_SIZE);

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                batch.add(line);

                if (batch.size() == BATCH_SIZE) {
                    processBatch(batch);
                    batch.clear(); // reset for next batch
                }
            }

            // process remaining lines (if any)
            if (!batch.isEmpty()) {
                processBatch(batch);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processBatch(List<String> batch) {
        // simulate processing, e.g., call DB or another service
        System.out.println("Processing batch of size: " + batch.size());

        // Example: print first 3 lines of batch
        for (int i = 0; i < Math.min(3, batch.size()); i++) {
            System.out.println(batch.get(i));
        }

        System.out.println("--- End of Batch ---\n");
    }

    public static void main(String[] args) {
        String filePath = "data.txt"; // replace with actual file path
        processLargeFile(filePath);
    }
}
