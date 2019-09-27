package xyz.shiqihao.jvm.classloader;

/**
 * 被动引用
 * 子类引用父类的静态字段不会引起子类的初始化
 */
public class NotInitialization1 {
    public static void main(String[] args) {
        System.out.println(SubClass.str);
    }
}

class SuperClass {
    static final String str = "hello";
}

class SubClass extends SuperClass {
    static {
        System.out.println("I am SubClass");
    }
}
