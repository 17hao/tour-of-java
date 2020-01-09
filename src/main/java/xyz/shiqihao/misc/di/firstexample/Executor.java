package xyz.shiqihao.misc.di.firstexample;

import com.google.inject.Guice;
import com.google.inject.Injector;
import xyz.shiqihao.misc.di.firstexample.definition.BillingService;
import xyz.shiqihao.misc.di.firstexample.implementation.BillingModule;

public class Executor {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new BillingModule());
        BillingService service = injector.getInstance(BillingService.class);
    }
}
