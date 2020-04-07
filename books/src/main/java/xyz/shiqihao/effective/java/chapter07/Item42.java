package xyz.shiqihao.effective.java.chapter07;

import java.util.Comparator;

/**
 * 从java8开始, 优先考虑使用lambda表达式创建函数对象而不是匿名类.
 * 最主要的原因是lambda表达式更简洁, 同时代表函数式编程这种新的思维方式.
 */
public class Item42 {
    void method() {
        Comparator<Integer> natureOrder = (i, j) -> (i < j) ? -1 : (i.equals(j) ? 0 : 1);
    }
}
