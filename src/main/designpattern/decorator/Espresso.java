package main.designpattern.decorator;

public class Espresso extends Beverage {
    Espresso(String d) {
        description = d;
    }

    @Override
    double cost() {
        return 1.99;
    }
}
