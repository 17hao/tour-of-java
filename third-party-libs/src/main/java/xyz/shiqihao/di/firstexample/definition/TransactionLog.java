package xyz.shiqihao.di.firstexample.definition;

import xyz.shiqihao.di.firstexample.implementation.ChargeResult;

public interface TransactionLog {
    void logChargeResult(ChargeResult result);
}
