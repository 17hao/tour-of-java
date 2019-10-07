package xyz.shiqihao.thinkinginjava.chap14_typeinfo;

public class SimpleProxyDemo {
    private static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("apple");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}
