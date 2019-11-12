package xyz.shiqihao.misc.di;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class Demo1 {
    private final ToBeInjected toBeInjected;

    @Inject
    Demo1(ToBeInjected toBeInjected) {
        this.toBeInjected = toBeInjected;
    }

    int doSomething() {
        return toBeInjected.subtract(10, 1);
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector();
        Demo1 demo1 = injector.getInstance(Demo1.class);
        System.out.println(demo1.doSomething());
    }
}
