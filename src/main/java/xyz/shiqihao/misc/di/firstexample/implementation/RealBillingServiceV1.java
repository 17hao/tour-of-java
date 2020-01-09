package xyz.shiqihao.misc.di.firstexample.implementation;

import xyz.shiqihao.misc.di.firstexample.definition.BillingService;
import xyz.shiqihao.misc.di.firstexample.definition.CreditCardProcessor;
import xyz.shiqihao.misc.di.firstexample.definition.TransactionLog;

/**
 * awful!
 * The direct, compile-time dependency on the real credit card processor means
 * that testing the code will char a credit card.
 */
public class RealBillingServiceV1 implements BillingService {
    @Override
    public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {
        CreditCardProcessor processor = new PaypalCreditCardProcessor();
        TransactionLog transactionLog = new DatabaseTransactionLog();
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
