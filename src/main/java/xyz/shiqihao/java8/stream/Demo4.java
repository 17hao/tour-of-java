package xyz.shiqihao.java8.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Getting stream from file.
 */
public class Demo4 {
    public static void main(String[] args) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get("./src/main/resources/input.txt"))) {
            List<String> result = lines
                    .flatMap(l -> Arrays.stream(l.split(" ")))
                    .distinct()
                    .collect(Collectors.toList());
            for (String s : result) {
                System.out.println(s);
            }
        }
    }
}
