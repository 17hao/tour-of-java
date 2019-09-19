package main.designpattern.decorator;

public class HouseBlend extends Beverage {
    HouseBlend() {
        description = "House Blend";
    }

    @Override
    double cost() {
        return 1.99;
    }
}
