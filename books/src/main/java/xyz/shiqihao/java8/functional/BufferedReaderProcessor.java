package xyz.shiqihao.java8.functional;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
interface BufferedReaderProcessor {
    String process(BufferedReader reader) throws IOException;
}
