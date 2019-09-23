package designpattern.decorator;

public class StarbuzzCoffee {
    public static void main(String[] args) {
        Beverage espresso = new Espresso();
        System.out.println("name: " + espresso.getDescription() + " cost: " + espresso.cost());

        Beverage beverage = new Espresso();
        beverage = new Mocha(beverage);
        System.out.println("name: " + beverage.getDescription() + " cost:" + beverage.cost());
    }
}
