package xyz.shiqihao.designpattern.factory;

public class Starter {
    public static void main(String[] args) {
        LocalPizzaStore store = new LocalPizzaStore();
        Pizza pizza = store.orderPizza("small");
        System.out.println(pizza.getName() + " pizza spend: " + pizza.getPrice());
    }
}
