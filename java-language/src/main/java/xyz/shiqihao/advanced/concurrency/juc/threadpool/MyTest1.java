package xyz.shiqihao.advanced.concurrency.juc.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * (1) 核心线程数是线程池中必须维持的线程数, 最大线程数是线程池最大能维持的线程数, 超过核心线程数的最大线程数会
 * 在Keep-alive times后被收回.
 * (2) 当使用FixedThreadPool时, corePoolSize和maximumPoolSize相同, 只要线程池中的线程数达到corePoolSize,
 * 接下来提交的任务都会放入workQueue中.
 * (3) 更一般地讲, 当线程池中线程数小于corePoolSize时, 只要有新的任务就创建新的线程, 当大于等于corePoolSize小于
 * maximumPoolSize时, 新的任务会被放入workQueue中, 只有当workQueue满了才会继续在线程池中创建新的线程直到线程数
 * 等于maximumPoolSize
 * (4) 如果workQueue是一个有界队列, 当任务将队列填满并且最大线程数也饱和; 或者线程池关闭时, 将调
 * 用RejectedExecutionHandler对无效的任务进行处理, 默认的处理方式是抛出异常.
 */
public class MyTest1 {
    private static class MyTask implements Runnable {
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() +
                    "[Thread id]: " + Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyTask task = new MyTask();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 1L,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(1));
        for (int i = 0; i < 20; i++) {
            executor.execute(task);
            System.out.println("Remaining tasks in workQueue: " + executor.getQueue().size());
        }
        executor.shutdown();
    }
}
