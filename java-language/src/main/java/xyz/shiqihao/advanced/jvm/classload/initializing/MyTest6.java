package xyz.shiqihao.advanced.jvm.classload.initializing;

/**
 * output: 2
 * 父类的<clinit>()方法先于子类执行
 */
public class MyTest6 {
    static class Parent {
        static int i = 1;

        static {
            i = 2;
        }
    }

    static class Sub extends Parent {
        static int j = i;
    }

    public static void main(String[] args) {
        System.out.println(Sub.j);
    }
}
