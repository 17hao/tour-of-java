package xyz.shiqihao.effective.java.chapter09;

import java.math.BigInteger;
import java.util.LinkedHashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

/**
 * 优先考虑使用接口类型声明变量, 而不是具体的实现类.
 * 例外情况:
 * ① String, BigInteger这样代表值的类.
 * ② 具体实现类提供了父接口没有的方法, 比如PriorityQueue提供了comparator()方法.
 */
public class Item64 {
    public static void main(String[] args) {
        // More flexible
        Set<Integer> s = new LinkedHashSet<>();
        Set<Integer> ss = new TreeSet<>();

        // Value classes are rarely written with multiple implementations.
        BigInteger i = BigInteger.valueOf(1);

        // The classes that implement an interface but provide extra methods.
        PriorityQueue<Integer> q = new PriorityQueue<>();
    }
}
