package xyz.shiqihao.advanced.concurrency.juc.sync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Sample usage of CyclicBarrier.
 *
 * Calculating sum of matrix.
 */
public class MyTest3 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Solver solver = new Solver(matrix);
        System.out.println(solver.getSum());
    }
}

class Solver {
    private final int[][] matrix;
    private final List<Integer> tmpSum;
    private int sum = 0;
    private final CyclicBarrier barrier;

    int getSum() {
        return sum;
    }

    class Worker implements Runnable {
        final int myRow;
        int sum = 0;

        @Override
        public void run() {
            int[] row = matrix[myRow];
            for (int value : row) {
                sum += value;
            }
            tmpSum.add(sum);
            try {
                barrier.await();
            } catch (BrokenBarrierException | InterruptedException ex) {
                ex.getStackTrace();
            }
        }

        Worker(int i) {
            myRow = i;
        }
    }

    Solver(int[][] matrix) {
        this.matrix = matrix;
        this.tmpSum = new ArrayList<>(matrix.length);
        int n = matrix.length;
        Runnable barrierAction = () -> {
            for (int v : tmpSum) {
                sum += v;
            }
        };
        barrier = new CyclicBarrier(matrix.length, barrierAction);
        List<Thread> threads = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(new Worker(i));
            threads.add(t);
            t.start();
        }
        try {
            for (Thread t : threads) {
                t.join();
            }
        } catch (InterruptedException ex) {
            ex.getStackTrace();
        }
    }
}
