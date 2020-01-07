package xyz.shiqihao.advanced.reflection;

import xyz.shiqihao.advanced.reflection.resource.C;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * access private by reflection.
 */
public class MyTest1 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        C c = new C();
        Method m = C.class.getDeclaredMethod("method1", String.class, List.class, int.class);
        m.setAccessible(true);
        System.out.println(m.invoke(c, "33", new ArrayList<>(), 23));
    }
}

