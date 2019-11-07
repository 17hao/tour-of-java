package xyz.shiqihao.java8.part_01.FunctionalInterface;

import java.io.BufferedReader;
import java.io.IOException;

public class ProcessFileMain {
    public static void main(String[] args) throws IOException {
        String oneLine = new FileProcessor().processFile(BufferedReader::readLine);
        System.out.println("oneLine: " + oneLine);
        String towLine = new FileProcessor().processFile(r -> r.readLine() + r.readLine());
        System.out.println("towLine: " + towLine);
    }
}
