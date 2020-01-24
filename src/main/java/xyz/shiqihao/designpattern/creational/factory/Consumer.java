package xyz.shiqihao.designpattern.creational.factory;

public class Consumer {
    public static void main(String[] args) {
        LocalPizzaStore store = new LocalPizzaStore();
        Pizza pizza = store.orderPizza("small");
        System.out.println(pizza + " spends: " + pizza.getPrice());
    }
}
