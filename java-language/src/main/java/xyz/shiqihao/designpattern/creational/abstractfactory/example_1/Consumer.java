package xyz.shiqihao.designpattern.creational.abstractfactory.example_1;

public class Consumer {
    public static void main(String[] args) {
        LocalPizzaStore store = new LocalPizzaStore();
        Pizza pizza = store.orderPizza("small");
        System.out.println(pizza + " spends: " + pizza.getPrice());
    }
}
