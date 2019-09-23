package xyz.shiqihao.designpattern.decorator;

abstract class Beverage {
    protected String description;

    String getDescription() {
        return description;
    }

    abstract double cost();
}
