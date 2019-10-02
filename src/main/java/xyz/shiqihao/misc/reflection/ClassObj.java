package xyz.shiqihao.misc.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Basic usage of instance of Class
 */
public class ClassObj {
    public static void main(String[] args) {
        Class aClass = MyObj.class;

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
        Class superclass = aClass.getSuperclass();
        System.out.println(superclass.getSimpleName());

        // Get interfaces
        Class[] interfaces = aClass.getInterfaces();
        for (Class c : interfaces) {
            System.out.println(c.getName());
        }

        // Get constructors
        Constructor[] constructors = aClass.getConstructors();
        for (Constructor c : constructors) {
            System.out.println(c.getName());
        }

        // modifier
        System.out.println(Modifier.isPublic(ClassObj.class.getModifiers()));
    }
}