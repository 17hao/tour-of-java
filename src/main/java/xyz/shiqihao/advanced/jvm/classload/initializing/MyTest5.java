package xyz.shiqihao.advanced.jvm.classload.initializing;

/**
 * output: 3
 */
public class MyTest5 {
    static class Parent {
        static int i = 1;

        static {
            i = 2;
        }
    }

    static class Sub extends Parent {
        static int j = i;

        static {
            j = 3;
        }
    }

    public static void main(String[] args) {
        System.out.println(Sub.j);
    }
}
