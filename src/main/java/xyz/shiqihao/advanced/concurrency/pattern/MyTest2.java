package xyz.shiqihao.advanced.concurrency.pattern;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * CompleteFuture基本用法
 */
public class MyTest2 {
    static class MySupplier implements Supplier<Integer> {

        @Override
        public Integer get() {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100;
        }
    }

    static class PlusOne implements Function<Integer, Integer> {

        @Override
        public Integer apply(Integer integer) {
            return integer + 1;
        }
    }

    public static void main(String[] args) throws Exception {
        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(new MySupplier());
        System.out.println(f1.isDone());
        CompletableFuture f2 = f1.thenApply(new PlusOne());
        System.out.println(f2.get());
    }
}
