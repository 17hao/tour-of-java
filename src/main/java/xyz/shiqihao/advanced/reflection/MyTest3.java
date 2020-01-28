package xyz.shiqihao.advanced.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * dynamic proxy
 * <p>
 * 最简单的方式是使用java.lang.reflect.Proxy创建动态代理. 基于单一职责的原则,
 * Proxy只负责代理的工作, 真正去调用被代理类方法的工作交给InvocationHandler.
 * 为了能调用被代理类的方法, handler中需要持有被代理类对象的引用, InvocationHandler只
 * 有一个invoke()方法, 调用invoke方法完成调用被代理类方法的工作.
 * <p>
 * 从背后实现来看, jvm生成代理类对用户是透明的, 所以才能被称作动态代理.
 * 实际上是调用了sun.misc.ProxyGenerator类, 生成的类型是$Proxy0.
 */
public class MyTest3 {
    interface Itf {
        void doSomething(String s);
    }

    static class OriginalClass implements Itf {
        @Override
        public void doSomething(String s) {
            System.out.println(s);
        }
    }

    static class Handler implements InvocationHandler {
        private Itf original;

        public Handler(Itf original) {
            this.original = original;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("BEFORE");
            method.invoke(original, args);
            System.out.println("AFTER");
            return null;
        }
    }

    public static void main(String[] args) {
        Itf original = new OriginalClass();
        InvocationHandler handler = new Handler(original);
        Itf foo = (Itf) Proxy.newProxyInstance(original.getClass().getClassLoader(),
                new Class[]{Itf.class}, handler);
        System.out.println(foo.getClass());
        foo.doSomething("hello, world!");
    }
}
