package main.designpattern.strategy;

public class SimUDuck {
    public static void main(String[] args) {
        ModelDuck modelDuck = new ModelDuck();
        modelDuck.performFly();
        modelDuck.performQuack();
    }
}
