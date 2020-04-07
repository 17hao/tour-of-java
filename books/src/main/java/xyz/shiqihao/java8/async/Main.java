package xyz.shiqihao.java8.async;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * I/O密集型的任务, CompletableFuture是比并行更好的选择.
 * N(thread) = N(cpu) * U(cpu) * (1 + W/C)
 * 线程池大小 = 可用cpu * 预期cpu利用率 * (1 + cpu等待/cpu计算 时间)
 * 如果并发任务数量 ≤ CPU核数, 并行的优势才能发挥出来.但是最多和合理使用的CompletableFuture持平.只能比串行的优势大.
 * 线程池核心线程数 ≥ 任务数量, CompletableFuture优势很大
 */
public class Main {

    private static final Executor EXECUTOR = Executors.newFixedThreadPool(
            Math.min(Runtime.getRuntime().availableProcessors(), 100), r -> {
                Thread thread = new Thread(r);
                thread.setDaemon(true);
                return thread;
            });

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println("Amount of processors: " + Runtime.getRuntime().availableProcessors());
        System.out.print("Sequentially: ");
        m.printExecTime(Main::findPricesSeq, "iPhone11");
        System.out.print("Parallel: ");
        m.printExecTime(Main::findPricesParallel, "iPhone11");
        System.out.print("CompletableFuture: ");
        m.printExecTime(Main::findPricesFuture, "iPhone11");
        // System.out.println("== separator ==");
        // System.out.print("Find discount prices: ");
        // m.printExecTime(Main::findDiscountPrices, "iPhone11");
        // System.out.print("Find discount prices in future: ");
        // m.printExecTime(Main::findDiscountPricesFuture, "iPhone11");
    }

    /**
     * Finding prices sequentially.
     */
    static List<String> findPricesSeq(String product) {
        return Shop.valueOf(Runtime.getRuntime().availableProcessors()).stream()
                .map(shop ->
                        String.format("%s price is %.2f",
                                shop.getName(),
                                shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    /**
     * Finding prices parallel.
     */
    static List<String> findPricesParallel(String product) {
        return Shop.valueOf(Runtime.getRuntime().availableProcessors()).parallelStream()
                .map(shop ->
                        String.format("%s price is %.2f",
                                shop.getName(),
                                shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    /**
     * Finding prices in future.
     */
    static List<String> findPricesFuture(String product) {
        List<CompletableFuture<String>> priceFuture =
                Shop.valueOf(Runtime.getRuntime().availableProcessors())
                        .stream()
                        .map(shop ->
                                CompletableFuture.supplyAsync(() ->
                                                String.format("%s price is %.2f",
                                                        shop.getName(),
                                                        shop.getPrice(product)),
                                        EXECUTOR))
                        .collect(Collectors.toList());

        return priceFuture.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    static List<String> findDiscountPrices(String product) {
        return Shop.valueOf(13).stream()
                .map(shop -> shop.getPriceV2(product))
                .map(Quote::parse)
                .map(Discount::applyDiscount)
                .collect(Collectors.toList());
    }

    static List<String> findDiscountPricesFuture(String product) {
        List<CompletableFuture<String>> priceFutures = Shop.valueOf(13).stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPriceV2(product), EXECUTOR))
                .map(future -> future.thenApply(Quote::parse))
                .map(future ->
                        future.thenCompose(quote ->
                                CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote))))
                .collect(Collectors.toList());

        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    private void printExecTime(PriceFinder<String> p, String product) {
        long start = System.nanoTime();
        p.findPrice(product);
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " ms");
    }
}
