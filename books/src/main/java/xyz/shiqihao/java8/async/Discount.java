package xyz.shiqihao.java8.async;

public class Discount {
    enum Code {
        NONE(0), SILVER(10), GOLD(15), PLATINUM(20), DIAMOND(25);
        private int percentage;

        Code(int i) {
            percentage = i;
        }
    }

    static String applyDiscount(Quote quote) {
        return quote.getShopName() + " price is: " + apply(quote.getPrice(), quote.getDiscountCode());
    }

    private static double apply(double price, Code code) {
        delay();
        return price * (100 - code.percentage) / 100;
    }

    private static void delay() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
