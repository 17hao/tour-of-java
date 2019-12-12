package xyz.shiqihao.effectivejava.chap09;

import java.math.BigInteger;
import java.util.LinkedHashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class Item64_ReferToObjByThierInterfaces {
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
