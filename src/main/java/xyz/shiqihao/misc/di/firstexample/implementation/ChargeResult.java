package xyz.shiqihao.misc.di.firstexample.implementation;

public class ChargeResult {
    private boolean result;
    private String note;

    ChargeResult(boolean result, String note) {
        this.result = result;
        this.note = note;
    }

    boolean isResult() {
        return result;
    }

    public String getDeclinedMessage() {
        return note;
    }

    public boolean wasSuccessful() {
        return result;
    }
}
