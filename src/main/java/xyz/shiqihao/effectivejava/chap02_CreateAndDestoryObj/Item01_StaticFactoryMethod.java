package xyz.shiqihao.effectivejava.chap02_CreateAndDestoryObj;

import java.math.BigInteger;

public class Item01_StaticFactoryMethod {
    public static void main(String[] args) {
        String str = String.valueOf(1);
        BigInteger i = BigInteger.valueOf(100);
        System.out.println(str + " " + i);
    }
}
