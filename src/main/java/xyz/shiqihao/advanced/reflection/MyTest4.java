package xyz.shiqihao.advanced.reflection;

import xyz.shiqihao.advanced.reflection.resource.MyClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * basic usage of Class object.
 */
public class MyTest4 {
    public static void main(String[] args) {
        Class<MyClass> aClass = MyClass.class;

        // Get declared methods
        Method[] methods = aClass.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println("method = " + m.getName());
        }

        // Get declared fields
        Field[] fields = aClass.getDeclaredFields();
        for (Field f : fields) {
            System.out.println("field = " + f.getName());
        }

        // Get package name
        Package pkg = aClass.getPackage();
        System.out.println(pkg.getName());

        // Get superclass
        Class<?> superclass = aClass.getSuperclass();
        System.out.println(superclass.getSimpleName());

        // Get interfaces
        Class<?>[] interfaces = aClass.getInterfaces();
        for (Class<?> c : interfaces) {
            System.out.println(c.getName());
        }

        // Get constructors
        Constructor<?>[] constructors = aClass.getConstructors();
        for (Constructor<?> c : constructors) {
            System.out.println(c.getName());
        }

        // modifier
        System.out.println(Modifier.isPublic(MyTest4.class.getModifiers()));
    }
}