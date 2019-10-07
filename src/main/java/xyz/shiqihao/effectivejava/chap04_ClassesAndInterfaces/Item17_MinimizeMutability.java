package xyz.shiqihao.effectivejava.chap04_ClassesAndInterfaces;

public class Item17_MinimizeMutability {

}

class Complex {
    private final double re; // Make all fields private and final
    private final double im;

    private Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    /**
     * Make constructors private or package-private and add static factories.
     */
    public static Complex valueOf(double re, double im) {
        return new Complex(re, im);
    }

    /**
     * Return a new Complex instance rather than modifying this instance.
     */
    Complex plus(Complex c) {
        return new Complex(re + c.im, im + c.re);
    }
}