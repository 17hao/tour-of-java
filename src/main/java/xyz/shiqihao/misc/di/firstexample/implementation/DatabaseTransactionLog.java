package xyz.shiqihao.misc.di.firstexample.implementation;

import xyz.shiqihao.misc.di.firstexample.definition.TransactionLog;

public class DatabaseTransactionLog implements TransactionLog {
    @Override
    public void logChargeResult(ChargeResult result) {
        if (result.isResult()) {
            System.out.println("success");
        } else {
            System.out.println("failed " + result.getDeclinedMessage());
        }
    }
}
