package xyz.shiqihao.misc.di.firstexample.implementation;

public class CreditCard {
    private final String num;
    private final int month;
    private final int year;

    public CreditCard(String num, int month, int year) {
        this.num = num;
        this.month = month;
        this.year = year;
    }

    public String getNum() {
        return num;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}
