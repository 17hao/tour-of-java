package designpattern.adapter;

public class FlyCar implements Car {
    private Plane plane;

    FlyCar(Plane plane) {
        this.plane = plane;
    }

    @Override
    public String drive() {
        return plane.fly();
    }
}
