package xyz.shiqihao.misc.di.firstexample.definition;

import xyz.shiqihao.misc.di.firstexample.implementation.ChargeResult;
import xyz.shiqihao.misc.di.firstexample.implementation.CreditCard;

public interface CreditCardProcessor {
    ChargeResult charge(CreditCard card, double amount);
}
