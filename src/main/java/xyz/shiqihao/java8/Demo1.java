package xyz.shiqihao.java8;

import java.util.Optional;

public class Demo1 {
    public static void main(String[] args) {
        Optional<String> op = Optional.empty();
        String result = op.orElse("null");
        System.out.println(result);
    }
}
