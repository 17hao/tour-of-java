package xyz.shiqihao.designpattern.behavioral.observer.example_2;

public abstract class Observer {
    protected Subject subject;

    public abstract void update();
}
