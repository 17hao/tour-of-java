package xyz.shiqihao.advanced.jvm.classload.initializing;

/**
 * 被动引用:
 * 通过创建数组引用的类不会引起该类的初始化
 */
public class MyTest3 {
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
