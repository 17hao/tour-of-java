package xyz.shiqihao.designpattern.creational.factory;

class BigPizza extends Pizza {
    BigPizza(String name, double price) {
        super.name = name;
        super.price = price;
    }

    @Override
    public String toString() {
        return "Big Pizza";
    }
}
