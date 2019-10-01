package xyz.shiqihao.designpattern.factory;

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
