package xyz.shiqihao.java8.FunctionalInterface;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
interface BufferedReaderProcessor {
    String process(BufferedReader reader) throws IOException;
}