package xyz.shiqihao.misc.di.firstexample.implementation;

import xyz.shiqihao.misc.di.firstexample.definition.CreditCardProcessor;

public class CreditCardProcessorFactory {
    private static CreditCardProcessor instance;

    public static CreditCardProcessor getInstance() {
        if (instance == null) {
            return new PaypalCreditCardProcessor();
        } else {
            return instance;
        }
    }

    public static void setInstance(CreditCardProcessor processor) {
        instance = processor;
    }
}
