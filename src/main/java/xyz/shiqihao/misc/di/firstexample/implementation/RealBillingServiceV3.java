package xyz.shiqihao.misc.di.firstexample.implementation;

import xyz.shiqihao.misc.di.firstexample.definition.BillingService;
import xyz.shiqihao.misc.di.firstexample.definition.CreditCardProcessor;
import xyz.shiqihao.misc.di.firstexample.definition.TransactionLog;

import javax.inject.Inject;

/**
 * The core principle of Dependency Injection is to separate behavior from
 * dependency resolution.
 */
public class RealBillingServiceV3 implements BillingService {
    private CreditCardProcessor processor;
    private TransactionLog transactionLog;

    @Inject
    public RealBillingServiceV3(CreditCardProcessor processor, TransactionLog transactionLog) {
        this.processor = processor;
        this.transactionLog = transactionLog;
    }

    @Override
    public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {
        try {
            ChargeResult result = processor.charge(creditCard, order.getAmount());
            transactionLog.logChargeResult(result);

            return result.wasSuccessful()
                    ? Receipt.forSuccessfulCharge(order.getAmount())
                    : Receipt.forDeclinedCharge(result.getDeclinedMessage());
        } catch (Exception e) {
            return Receipt.forSystemFailure("system failure");
        }
    }
}
