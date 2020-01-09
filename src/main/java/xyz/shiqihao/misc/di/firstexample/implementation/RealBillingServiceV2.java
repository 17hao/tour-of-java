package xyz.shiqihao.misc.di.firstexample.implementation;

import xyz.shiqihao.misc.di.firstexample.definition.BillingService;
import xyz.shiqihao.misc.di.firstexample.definition.CreditCardProcessor;
import xyz.shiqihao.misc.di.firstexample.definition.TransactionLog;

/**
 * A factory decouples the client and implementing classes.
 * A simple factory uses static methods to set and get mock implementations for interface.
 */
public class RealBillingServiceV2 implements BillingService {
    @Override
    public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {
        CreditCardProcessor processor = CreditCardProcessorFactory.getInstance();
        TransactionLog transactionLog = TransactionLogFactory.getInstance();
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
