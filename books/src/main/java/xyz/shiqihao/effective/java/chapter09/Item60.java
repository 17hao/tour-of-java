package xyz.shiqihao.effective.java.chapter09;

import java.math.BigDecimal;

/**
 * 对于要得到精确结果的运算, 不要使用float和double. 原因见AAA行代码.
 * 要使用BigDecimal, int, long来进行要得到精确结果的计算.
 */
public class Item60 {
    public static void main(String[] args) {
        // Don't use float and double if exact answers are required!
        System.out.println(1.03 - 0.42); // AAA print: 0.6100000000000001
        BigDecimal n = BigDecimal.valueOf(1.03);
        BigDecimal m = BigDecimal.valueOf(0.42);
        System.out.println(n.subtract(m)); // 0.61
    }
}
