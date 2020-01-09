package xyz.shiqihao.misc.di.firstexample.implementation;

import xyz.shiqihao.misc.di.firstexample.definition.TransactionLog;

public class TransactionLogFactory {
    private static TransactionLog instance;

    public static TransactionLog getInstance() {
        if (instance == null) {
            return new DatabaseTransactionLog();
        } else {
            return instance;
        }
    }

    public static void setInstance(TransactionLog transactionLog) {
        instance = transactionLog;
    }
}
