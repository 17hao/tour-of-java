package etc.designpattern.adapter;

public class Client {
    public static void main(String[] args) {
        Plane plane = new ConcretePlane();
        Car car = new FlyCar(plane);
        System.out.println(car.drive());
    }
}
