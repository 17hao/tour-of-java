package etc.reflection;

import java.lang.reflect.Method;

public class MyObj {
    public static void main(String[] args) {
        Method[] methods = MyObj.class.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println("method = " + m.getName());
        }
    }

    void method1() {
    }

    void method2() {
    }

    void method3() {
    }
}
