package main.thinkinginjava.chapter08_polymorphism.shape;

class Circle extends Shape {
    void draw() {
        System.out.println("Circle.draw()");
    }

    void erase() {
        System.out.println("Circle.erase()");
    }
}
