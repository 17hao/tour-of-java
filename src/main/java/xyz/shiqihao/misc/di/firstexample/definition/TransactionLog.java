package xyz.shiqihao.misc.di.firstexample.definition;

import xyz.shiqihao.misc.di.firstexample.implementation.ChargeResult;

public interface TransactionLog {
    void logChargeResult(ChargeResult result);
}
