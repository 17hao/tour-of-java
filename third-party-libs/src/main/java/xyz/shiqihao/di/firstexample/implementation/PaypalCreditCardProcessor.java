package xyz.shiqihao.di.firstexample.implementation;

import xyz.shiqihao.di.firstexample.definition.CreditCardProcessor;

public class PaypalCreditCardProcessor implements CreditCardProcessor {
    @Override
    public ChargeResult charge(CreditCard card, double amount) {
        return new ChargeResult(card.getNum().length() < 10, "");
    }
}
