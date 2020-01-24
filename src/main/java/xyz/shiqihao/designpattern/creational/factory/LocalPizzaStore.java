package xyz.shiqihao.designpattern.creational.factory;

class LocalPizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(String type) {
        if (type.equals("small")) {
            return new SmallPizza(type, 1);
        } else {
            return new BigPizza(type, 2);
        }
    }
}
