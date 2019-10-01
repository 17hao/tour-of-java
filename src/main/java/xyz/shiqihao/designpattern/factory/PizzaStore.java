package xyz.shiqihao.designpattern.factory;

abstract class PizzaStore {
    abstract Pizza createPizza(String type);

    Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        pizza.prepare(pizza);
        pizza.box(pizza);
        return pizza;
    }
}

class Pizza {
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    Pizza(String name, double price) {
        this.name = name;
        this.price = price;
    }

    Pizza prepare(Pizza pizza) {
        System.out.println("preparing pizza");
        return pizza;
    }

    Pizza box(Pizza pizza) {
        System.out.println("boxing pizza");
        return pizza;
    }


}
