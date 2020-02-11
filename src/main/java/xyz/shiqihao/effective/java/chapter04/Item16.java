package xyz.shiqihao.effective.java.chapter04;

/**
 * Encapsulation of data by accessor methods and mutator in public classes.
 * Expose immutable fields in public classes is still questionable.
 * Expose mutable fields in public class is dangerous.
 */
public class Item16 {
    static private Point p = new Point(1.0, 2.0, 3.0);

    public static void main(String[] args) {
        System.out.println("x: " + p.getX() + " y: " + p.y + " z: " + p.z);
        p.z = 4.0;
        System.out.println(p.z);
    }
}

class Point {
    private double x; // good
    public final double y; // questionable
    public double z; // awful

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }
}