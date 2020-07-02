package xyz.shiqihao.advanced.jvm.classload.initializing;

/**
 * 可能是最常用的一种主动引起类初始化的动作:static代码块
 *
 * output: static block main method
 */
public class MyTest0 {
    static {
        System.out.println("static block");
    }

    public static void main(String[] args) {
        System.out.println("main method");
    }
}
