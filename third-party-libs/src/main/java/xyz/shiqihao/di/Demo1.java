package xyz.shiqihao.di;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class Demo1 {
    private final AClass AClass;

    @Inject
    Demo1(AClass AClass) {
        this.AClass = AClass;
    }

    int doSomething() {
        return AClass.subtract(10, 1);
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector();
        Demo1 demo1 = injector.getInstance(Demo1.class);
        System.out.println(demo1.doSomething());
    }
}
