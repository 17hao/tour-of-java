package xyz.shiqihao.effective.java.chapter09;

import java.util.Random;

/**
 * 对于字符串连接优先使用StringBuilder类而不是用'+'相连
 * 字符串长度1000, 性能差距8倍.
 */
public class Item63 {
    public static void main(String[] args) {
        // Inappropriate use of String concatenation - Performs poorly!
        long s1 = System.currentTimeMillis();
        String result = "";
        for (int i = 0; i < 1000; i++) {
            result += String.valueOf(new Random().nextInt(9));
        }
        System.out.println("Length of String: " + result.length() +
                " spent: " + (System.currentTimeMillis() - s1));

        long s2 = System.currentTimeMillis();
        StringBuilder b = new StringBuilder(200);
        for (int i = 0; i < 1000; i++) {
            b.append(new Random().nextInt(9));
        }
        System.out.println("Length of String: " + b.toString().length() +
                " spent: " + (System.currentTimeMillis() - s2));
    }
}
