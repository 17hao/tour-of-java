package xyz.shiqihao.java8.async;

public class Discount {
    enum Code {
        NONE(0), SILVER(10), GOLD(15), PLATINUM(20), DIAMOND(25);
        private int percentage;

        Code(int i) {
            percentage = i;
        }
    }
}
