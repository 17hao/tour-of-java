package xyz.shiqihao.designpattern.decorator;

class Mocha extends CondimentDecorator {
    private Beverage beverage;

    Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    String getDescription() {
        return beverage.getDescription() + " decorate by mocha";
    }

    @Override
    double cost() {
        return beverage.cost() + 1.0;
    }
}
