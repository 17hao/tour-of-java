package xyz.shiqihao.java8.async;

import java.util.ArrayList;
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

    /**
     * @return ShopName:price:DiscountCode
     */
    String getPriceV2(String product) {
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[
                new Random().nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", name, price, code);
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

    static List<Shop> valueOf(int i) {
        if (i <= 4) {
            return fourShops;
        } else {
            List<Shop> result = new ArrayList<>();
            for (int j = 1; j <= i - 4; j++) {
                result.add(new Shop("PlainShop" + j));
            }
            result.addAll(fourShops);
            return result;
        }
    }

    private static List<Shop> fourShops = Arrays.asList(
            new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"));
}
