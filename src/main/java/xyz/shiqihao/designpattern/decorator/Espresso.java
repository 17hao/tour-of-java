package xyz.shiqihao.designpattern.decorator;

class Espresso extends Beverage {
    Espresso() {
        description = "espresso";
    }

    @Override
    double cost() {
        return 1.99;
    }
}
