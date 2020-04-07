package xyz.shiqihao.di.firstexample;

import com.google.inject.Guice;
import com.google.inject.Injector;
import xyz.shiqihao.di.firstexample.definition.BillingService;
import xyz.shiqihao.di.firstexample.implementation.BillingModule;

/**
 * Guice通过@inject注解声明了通过构方法注入的方式组装对象.
 * BillingModule告诉IoC Container剩余的依赖关系, 也就是用哪种具体类型的对象进行组装.
 */
public class Executor {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new BillingModule());
        BillingService service = injector.getInstance(BillingService.class);
    }
}
