package xyz.shiqihao.effectivejava.chap09_GeneralProgramming;

import java.math.BigDecimal;

public class Item60_AvoidFloatAndDouble {
    public static void main(String[] args) {
        // Don't use float and double if exact answers are required!
        System.out.println(1.03 - 0.42); // 0.6100000000000001
        BigDecimal n = BigDecimal.valueOf(1.03);
        BigDecimal m = BigDecimal.valueOf(0.42);
        System.out.println(n.subtract(m)); // 0.61
    }
}
