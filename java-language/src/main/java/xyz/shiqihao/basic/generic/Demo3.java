package xyz.shiqihao.basic.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 通配符的含义是unknown,意味着类型的不确定
 */
public class Demo3 {
    static void printElement1(List<? extends Number> l) {
        for (Number n : l) {
            System.out.println(n);
        }
    }

    static <T> void printElement2(List<T> l) {
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

    public static void main(String[] args) {
        List<Number> l = new ArrayList<>();
        l.add(1);
        l.add(2.0);
        printElement1(l);
    }
}
