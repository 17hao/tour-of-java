package xyz.shiqihao.designpattern.factory;

abstract class PizzaStore {
    abstract Pizza createPizza(String type);

    Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.box();
        return pizza;
    }
}
