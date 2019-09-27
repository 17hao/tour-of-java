package xyz.shiqihao.jvm.classloader;

/**
 * 通过创建数组引用的类不会引起该类的初始化
 * 数组是由jvm直接创建的
 */
public class NotInitialization2 {
    public static void main(String[] args) {
        SuperClass[] arr = new SuperClass[10];
    }
}
