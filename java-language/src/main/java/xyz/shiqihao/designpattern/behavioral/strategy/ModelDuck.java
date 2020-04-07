package xyz.shiqihao.designpattern.behavioral.strategy;

class ModelDuck extends Duck {
    ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new MuteQuack();
    }

    void performFly() {
        flyBehavior.fly();
    }

    void performQuack() {
        quackBehavior.quack();
    }
}
