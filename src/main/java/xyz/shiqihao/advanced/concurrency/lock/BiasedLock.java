package xyz.shiqihao.advanced.concurrency.lock;

import java.util.Vector;

/**
 * java -XX:+UseBiasedLocking -XX:BiasedLockingStartupDelay=0
 * -cp src/main/java xyz.shiqihao.advanced.concurrency.lock.BiasedLock
 *
 * 使用偏向锁, 在竞争不激烈的情况下可以提升10% ~ 20% 的性能
 */
public class BiasedLock {
    static Vector<Integer> numList = new Vector<>();

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int num = 0;
        int count = 0;
        while (count++ < 10000000) {
            numList.add(num++);
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
