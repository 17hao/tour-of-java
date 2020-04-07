package xyz.shiqihao.advanced.concurrency.juc.threadpool;

import xyz.shiqihao.basic.annotations.Todo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * ForkJoinPool
 */
@Todo(author = "sqh", priority = Todo.Priority.MEDIUM, status = Todo.Status.OPEN)
public class MyTest6 {
    static class CountTask extends RecursiveTask<Long> {
        private static final int THRESHOLD = 10000;
        private long start;
        private long end;

        public CountTask(long start, long end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            long sum = 0;
            boolean canCompute = (end - start) < THRESHOLD;
            if (canCompute) {
                for (long i = start; i <= end; i++) {
                    sum += i;
                }
            } else {
                long step = (end + start) / THRESHOLD;
                List<CountTask> subTasks = new ArrayList<>();
                long pos = start;
                for (int i = 0; i < 100; i++) {
                    long lastOne = pos + step;
                    if (lastOne > end) lastOne = end;
                    CountTask subTask = new CountTask(pos, lastOne);
                    pos += step + 1;
                    subTasks.add(subTask);
                    subTask.fork();
                }
                for (CountTask t : subTasks) {
                    sum += t.join();
                }
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        long s1 = System.currentTimeMillis();
        ForkJoinTask<Long> res = pool.submit(new CountTask(1, 200000));
        try {
            System.out.println("res: " + res.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("[ForJoinPool] " + (System.currentTimeMillis() - s1));

        long s2 = System.currentTimeMillis();
        long sum = 0;
        for (long i = 0; i < 200000; i++) {
            sum += i;
        }
        System.out.println("sum: " + sum);
        System.out.println("[Seq alg] " + (System.currentTimeMillis() - s2));
    }
}
