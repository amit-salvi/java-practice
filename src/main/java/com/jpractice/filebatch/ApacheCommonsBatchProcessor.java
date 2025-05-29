package com.jpractice.filebatch;

import org.apache.commons.io.LineIterator;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApacheCommonsBatchProcessor {

    private static final int BATCH_SIZE = 1000;

    public static void processLargeFile(String filePath) {
        File file = new File(filePath);
        List<String> batch = new ArrayList<>(BATCH_SIZE);

        try (LineIterator it = FileUtils.lineIterator(file, "UTF-8")) {
            while (it.hasNext()) {
                String line = it.nextLine();
                batch.add(line);

                if (batch.size() == BATCH_SIZE) {
                    processBatch(batch);
                    batch.clear();
                }
            }

            if (!batch.isEmpty()) {
                processBatch(batch);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processBatch(List<String> batch) {
        System.out.println("Processing batch of size: " + batch.size());
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
