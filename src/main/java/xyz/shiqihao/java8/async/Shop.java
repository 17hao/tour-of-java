package xyz.shiqihao.java8.async;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

class Shop {
    private final String name;

    Shop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    double getPrice(String product) {
        return calculatePrice(product);
    }

    public Future<Double> getPriceAsync(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    private double calculatePrice(String product) {
        delay();
        return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
    }

    private static void delay() {
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static List<Shop> fourShops = Arrays.asList(
            new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"));

    static List<Shop> nineShops = Arrays.asList(
            new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"),
            new Shop("PlainShop1"),
            new Shop("PlainShop2"),
            new Shop("PlainShop3"),
            new Shop("PlainShop4"),
            new Shop("PlainShop5"));

    static List<Shop> twelveShops = Arrays.asList(
            new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"),
            new Shop("PlainShop1"),
            new Shop("PlainShop2"),
            new Shop("PlainShop3"),
            new Shop("PlainShop4"),
            new Shop("PlainShop5"),
            new Shop("PlainShop6"),
            new Shop("PlainShop7"),
            new Shop("PlainShop8"));
}
