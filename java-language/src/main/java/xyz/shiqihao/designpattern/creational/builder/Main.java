package xyz.shiqihao.designpattern.creational.builder;

/**
 * Builder模式的用途在于构建复杂对象, 一次性无法构建完对象, 要一步步构建一部分. 从表现形式上看
 * 借助一个Builder对象, 每次设置一部分对象属性并返回Builder对象本身.
 * 在jdk中的应用比较典型的有StringBuilder.append() / StringBuffer.append()
 */
public class Main {
    public static void main(String[] args) {
        Car c = new Car.Builder("v6", "sqh").color("red").price(1.0).build();
        System.out.println(c);
    }
}
