package main.designpattern.decorator;

abstract class Beverage {
    String description;

    String getDescription() {
        return description;
    }

    abstract double cost();
}
