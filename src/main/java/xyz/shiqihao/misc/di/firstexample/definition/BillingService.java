package xyz.shiqihao.misc.di.firstexample.definition;

import xyz.shiqihao.misc.di.firstexample.implementation.CreditCard;
import xyz.shiqihao.misc.di.firstexample.implementation.PizzaOrder;
import xyz.shiqihao.misc.di.firstexample.implementation.Receipt;

public interface BillingService {
    Receipt chargeOrder(PizzaOrder order, CreditCard creditCard);
}
