package xyz.shiqihao.basic.exceptions;

import java.util.Random;

/**
 * 受检查异常的特点:
 * 1. 继承自Exception而不是RuntimeException
 * 2. 使用时不仅要在方法内throw, 还要在方法声明后用throws指明可能发生的异常
 * 3. 强制调用方程序员处理. 处理分2种: 一种是在调用方法声明后也用throws关键字抛出, 交给后续调用的方法处理.
 * 另一种是在调用时用try/catch处理.
 */
public class MyTest2 {
    public static void main(String[] args) {
        try {
            doSomething(new Random().nextInt(10) < 5);
        } catch (CheckedException e) {
            e.printStackTrace();
        }
    }

    private static void doSomething(boolean sthWrong) throws CheckedException {
        if (sthWrong) {
            throw new CheckedException("Something wrong.");
        } else {
            System.out.println("Everything is ok.");
        }
    }
}
