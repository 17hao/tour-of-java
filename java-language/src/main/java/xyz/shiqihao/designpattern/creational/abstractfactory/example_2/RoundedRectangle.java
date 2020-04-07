package xyz.shiqihao.designpattern.creational.abstractfactory.example_2;

public class RoundedRectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("I am a rounded rectangle.");
    }
}
