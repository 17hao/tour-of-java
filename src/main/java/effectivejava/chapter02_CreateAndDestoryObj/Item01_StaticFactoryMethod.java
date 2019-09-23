package effectivejava.chapter02_CreateAndDestoryObj;

import java.math.BigInteger;

public class Item01_StaticFactoryMethod {
    public static void main(String[] args) {
        Boolean b = Boolean.valueOf(true);
        BigInteger i = BigInteger.valueOf(100);
        System.out.println(b + " " + i);
    }
}
