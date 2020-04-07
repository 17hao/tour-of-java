package xyz.shiqihao.designpattern.creational.abstractfactory.example_1;

class SmallPizza extends Pizza {
    SmallPizza(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Small Pizza";
    }
}
