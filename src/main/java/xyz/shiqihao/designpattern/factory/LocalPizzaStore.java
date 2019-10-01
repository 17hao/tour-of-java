package xyz.shiqihao.designpattern.factory;

class LocalPizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(String type) {
        if (type.equals("little")) {
            return new Pizza(type, 1);
        } else if (type.equals("middle")) {
            return new Pizza(type, 2);
        } else {
            return new Pizza(type, 3);
        }
    }
}
