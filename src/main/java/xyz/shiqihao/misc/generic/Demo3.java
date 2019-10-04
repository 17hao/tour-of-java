package xyz.shiqihao.misc.generic;

import java.util.List;

/**
 * 通配符的含义是unknown,意味着类型的不确定
 */
public class Demo3 {
    void printElement1(List<? extends Number> l) {
        for (Number n : l) {
            System.out.println(n);
        }
    }

    <T> void printElement2(List<T> l) {
        for (T t : l) {
            System.out.println(t);
        }
    }

    // Compile time error!
    // void addElement(List<? extends Number> l, Number number) {
    //     l.add(number);
    // }

    <T extends Number> void addElement2(List<T> l, T number) {
        l.add(number);
    }
}
