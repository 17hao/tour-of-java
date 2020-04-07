package xyz.shiqihao.effective.java.chapter09;

import java.util.Comparator;

/**
 * 优先考虑使用基本类型而不是包装类型.
 * ① 性能因素, 包装类是对象, 创建回收的代价更高.
 * ② 安全因素, 包装类通过引用获取到对象, 会导致2个引用指向一个值, 容易出错.
 */
public class Item61 {
    public static void main(String[] args) {
        // Don't do this!
        Comparator<Integer> natureOrder = (i, j) -> (i < j) ? -1 : (i == j ? 0 : -1);
        System.out.println(natureOrder.compare(new Integer(1), new Integer(1)));
    }
}
