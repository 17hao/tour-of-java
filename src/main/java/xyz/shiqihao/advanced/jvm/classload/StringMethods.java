package xyz.shiqihao.advanced.jvm.classload;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 获取java.lang.String类的所有方法和签名中的类型
 */
public class StringMethods {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("java.lang.String");
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            String mod = Modifier.toString(m.getModifiers());
            System.out.print(mod + " " + m.getName() + " (");
            Class<?>[] parameters = m.getParameterTypes();
            if (parameters.length == 0) System.out.println(")");
            for (int i = 0; i < parameters.length; i++) {
                char end = i == parameters.length - 1 ? ')' : ',';
                System.out.print(parameters[i].getSimpleName() + end);
            }
            System.out.println();
        }
    }
}
