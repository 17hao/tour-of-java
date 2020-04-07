package xyz.shiqihao.di.firstexample.definition;

import xyz.shiqihao.di.firstexample.implementation.CreditCard;
import xyz.shiqihao.di.firstexample.implementation.PizzaOrder;
import xyz.shiqihao.di.firstexample.implementation.Receipt;

public interface BillingService {
    Receipt chargeOrder(PizzaOrder order, CreditCard creditCard);
}
