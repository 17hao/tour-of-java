package xyz.shiqihao.java8.async;

public class Quote {
    private final String shopName;
    private final double price;
    private final Discount.Code discountCode;

    Quote(String name, double price, Discount.Code discountCode) {
        this.shopName = name;
        this.price = price;
        this.discountCode = discountCode;
    }

    static Quote parse(String s) {
        String[] split = s.split(":");
        String name = split[0];
        double price = Double.parseDouble(split[1]);
        Discount.Code code = Discount.Code.valueOf(split[2]);
        return new Quote(name, price, code);
    }

    public String getShopName() {
        return shopName;
    }

    public double getPrice() {
        return price;
    }

    public Discount.Code getDiscountCode() {
        return discountCode;
    }
}
