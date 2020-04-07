package xyz.shiqihao.solid.dip;

public class Utility implements PolicyInterface {
    @Override
    public void provideSomeAbility() {
        System.out.println("I'm a util, and provide some ability.");
    }
}
