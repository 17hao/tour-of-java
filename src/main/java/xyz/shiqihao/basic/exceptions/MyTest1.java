package xyz.shiqihao.basic.exceptions;

import java.util.Random;

/**
 * 未受检查异常的特点:
 * 1. 继承自RuntimeException
 * 2. 用throw关键字在方法内抛出, 而不像throws关键字在方法声明后抛出
 * 3. 不强制调用方程序员处理.
 *
 * CheckedException vs UncheckedException
 * 1. 一种异常可以做到的另一种异常也能做到, 性能上也不会有差异.
 * 2. 在scala和c#中是没有受检查异常的.
 * 3. 受检查异常强制提醒程序员处理异常, 但是很多时候程序员就是简单try/catch一下, 还不如不检查.
 * 4. 在项目中同时采用2种异常, 虽然能同时带来2种异常的优点, 但是也会带来2种异常的缺点. 引入缺点其实更致命. 所以
 * 倒不如在项目中只用一种异常.
 */
public class MyTest1 {
    public static void main(String[] args) {
        doSomething(new Random().nextInt(10) < 5);
    }

    private static void doSomething(boolean sthWrong) {
        if (sthWrong) {
            throw new UncheckedException("Something wrong.");
        } else {
            System.out.println("Everything is ok.");
        }
    }
}
