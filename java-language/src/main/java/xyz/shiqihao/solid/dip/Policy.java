package xyz.shiqihao.solid.dip;

public class Policy {
    PolicyInterface util;

    void businessLogic() {
        System.out.println("do something...");
        util.provideSomeAbility();
    }
}
