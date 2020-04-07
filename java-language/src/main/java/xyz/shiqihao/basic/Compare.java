package xyz.shiqihao.basic;

import java.util.Arrays;

public class Compare {
    public static void main(String[] args) {
        String[] x = {"2", "1", "3", "0", "-1"};
        Arrays.sort(x, String::compareTo);
        System.out.println(Arrays.toString(x));
    }
}
