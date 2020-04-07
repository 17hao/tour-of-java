package xyz.shiqihao.basic.collection;

import java.util.PriorityQueue;

/**
 * priority queue
 */
public class MyTest2 {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(2, (n1, n2) -> n1 - n2);
        queue.add(2);
        queue.add(2);
        queue.add(4);
        queue.add(1);
        System.out.println(queue);
    }
}
