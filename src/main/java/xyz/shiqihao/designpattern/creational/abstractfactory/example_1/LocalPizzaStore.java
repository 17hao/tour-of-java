package xyz.shiqihao.designpattern.creational.abstractfactory.example_1;

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
