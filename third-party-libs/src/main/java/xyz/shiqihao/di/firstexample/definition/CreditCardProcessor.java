package xyz.shiqihao.di.firstexample.definition;

import xyz.shiqihao.di.firstexample.implementation.ChargeResult;
import xyz.shiqihao.di.firstexample.implementation.CreditCard;

public interface CreditCardProcessor {
    ChargeResult charge(CreditCard card, double amount);
}
