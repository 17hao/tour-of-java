package etc.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Basic usage of instance of Class
 */
public class ClassObj {
    public static void main(String[] args) {
        Class obj = MyObj.class;

        // Get declared methods
        Method[] methods = obj.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println("method = " + m.getName());
        }

        // Get declared fields
        Field[] fields = obj.getDeclaredFields();
        for (Field f : fields) {
            System.out.println("field = " + f.getName());
        }

        // Get package name
        Package pkg = obj.getPackage();
        System.out.println(pkg.getName());

        // Get superclass
        Class superclass = obj.getSuperclass();
        System.out.println(superclass.getSimpleName());

        // Get interfaces
        Class[] interfaces = obj.getInterfaces();
        for (Class c : interfaces) {
            System.out.println(c.getName());
        }

        // Get constructors
        Constructor[] constructors = obj.getConstructors();
        for (Constructor c : constructors) {
            System.out.println(c.getName());
        }

        // modifier
        System.out.println(Modifier.isPublic(ClassObj.class.getModifiers()));
    }
}

class MyObj extends SuperClass implements MyInterface {
    private int f = 1;

    public MyObj() {
    }

    @Override
    public void method1() {

    }

    class InnerClass {
    }
}

class SuperClass {
}

interface MyInterface {
    void method1();
}