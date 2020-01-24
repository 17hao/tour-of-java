package xyz.shiqihao.designpattern.structral.decorator;

abstract class Beverage {
    protected String description;

    String getDescription() {
        return description;
    }

    abstract double cost();
}
