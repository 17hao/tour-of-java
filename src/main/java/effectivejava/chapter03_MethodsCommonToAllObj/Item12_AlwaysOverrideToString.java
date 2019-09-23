package main.effectivejava.chapter03_MethodsCommonToAllObj;

public class Item12_AlwaysOverrideToString {
}

class MobilePhone {
    private final String brand;

    MobilePhone(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "This is a " + brand + " mobile phone.";
    }
}
