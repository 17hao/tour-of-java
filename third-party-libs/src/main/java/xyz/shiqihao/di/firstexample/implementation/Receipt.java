package xyz.shiqihao.di.firstexample.implementation;

public class Receipt {
    private final double amount;
    private final String note;

    private Receipt(double amount, String note) {
        this.amount = amount;
        this.note = note;
    }

    public static Receipt forSuccessfulCharge(double amount) {
        return new Receipt(amount, "");
    }

    public static Receipt forDeclinedCharge(String message) {
        return new Receipt(0, message);
    }

    public static Receipt forSystemFailure(String message) {
        return new Receipt(0, message);
    }
}
