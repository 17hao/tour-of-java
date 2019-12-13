package xyz.shiqihao.advanced.jvm.classload;

/**
 * 通过创建数组引用的类不会引起该类的初始化
 * 数组是由jvm直接创建的
 */
public class MyTest8 {
    public static void main(String[] args) {
        System.out.println("creating array");
        Arr[] arr = new Arr[10];
    }
}

class Arr {
    static {
        System.out.println("class Arr init");
    }
}
