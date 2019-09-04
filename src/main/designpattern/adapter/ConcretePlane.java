package main.designpattern.adapter;

public class ConcretePlane implements Plane {
    @Override
    public String fly() {
        return "fly";
    }
}
