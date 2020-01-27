package xyz.shiqihao.advanced.reflection;

import xyz.shiqihao.advanced.reflection.resource.A;
import xyz.shiqihao.advanced.reflection.resource.C;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Class中的方法大致上分为4类:
 * 1.获取字段
 * 2.获取方法
 * 3.获取构造方法
 * 4.获取注解.
 * <p>
 * 每一类中又分为4种:
 * 1.所有公有且包括来自父类的 i.e. getMethods()
 * 2.所有任意访问权限且不是父类的 i.e. getDeclaredMethods()
 * 3.指定公有且来自父类的 i.e. getMethod(String name, Class<?>...parameterTypes)
 * 4.指定任意访问权限且不是父类的 i.e. getDeclaredMethod(String name, Class<?>...parameterTypes)
 * <p>
 * 对于注解, 只有元注解@Retention(RetentionPolicy.RUNTIME)才能被反射访问到. 因为反射是运行
 * 时的操作, 所以只有保留到运行时的注解才能被访问到.
 * 获取方法参数上的注解getParameterAnnotations()返回二维数组, 每个参数的注解是一个一维数组.
 */
public class MyTest2 {
    public static void main(String[] args) throws Exception {
        Class<?> c = Class.forName("java.lang.String");
        Method[] methods = c.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("===");
        Method[] declaredMethods = c.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method);
        }

        System.out.println(c.getMethod("toString"));
        System.out.println(c.getDeclaredMethod("checkBounds", byte[].class, int.class, int.class));
        System.out.println(c.getDeclaredField("value"));
        System.out.println(c.getConstructor(char[].class));
        System.out.println("===");
        Class<?> clazz = C.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation a : annotations) {
            System.out.println(a);
        }
        System.out.println("The value of annotation A: " + clazz.getAnnotation(A.class).value());
        System.out.println("The value of annotation A: " +
                clazz.getDeclaredField("aField").getAnnotation(A.class).value());
        System.out.println("The value of annotation A: " +
                clazz.getDeclaredMethod("aMethod", String.class).getAnnotation(A.class).value());
        System.out.println("The value of annotation A: " +
                ((A) (clazz.getDeclaredMethod("aMethod", String.class).
                        getParameterAnnotations())[0][0]).value());
    }
}
