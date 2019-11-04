package xyz.shiqihao.java8.FunctionalInterface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class FileProcessor {
    String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("./src/main/resources/Source.html"))) {
            return p.process(reader);
        }
    }
}
