package xyz.shiqihao.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo2 {
    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(1, 2, 3, 4, 2, 3, 4, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> result = l.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(result);
    }
}
