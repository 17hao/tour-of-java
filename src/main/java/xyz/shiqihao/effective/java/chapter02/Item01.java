package xyz.shiqihao.effective.java.chapter02;

import java.math.BigInteger;

/**
 * Consider static factory methods instead of constructors.
 * 静态工厂方法的一些优势:
 * 1. 他们有名字. 这可以使调用静态工厂方法的客户端代码可读性更强.
 * 2. 可以做到不用像构造方法一样每次调用创建一个新的对象. 这类似于设计模式中的享元模式.
 * 3. 返回的类型可以随着参数的变化而变化.
 */
public class Item01 {
    public static void main(String[] args) {
        String str = String.valueOf(1);
        BigInteger i = BigInteger.valueOf(100);
        System.out.println(str + " " + i);
    }
}
