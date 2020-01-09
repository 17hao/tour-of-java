package xyz.shiqihao.misc.di.firstexample.implementation;

import com.google.inject.AbstractModule;
import xyz.shiqihao.misc.di.firstexample.definition.BillingService;
import xyz.shiqihao.misc.di.firstexample.definition.CreditCardProcessor;
import xyz.shiqihao.misc.di.firstexample.definition.TransactionLog;

public class BillingModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(TransactionLog.class).to(DatabaseTransactionLog.class);
        bind(CreditCardProcessor.class).to(PaypalCreditCardProcessor.class);
        bind(BillingService.class).to(RealBillingServiceV3.class);
    }
}
