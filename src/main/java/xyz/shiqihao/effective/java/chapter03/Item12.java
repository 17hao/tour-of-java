package xyz.shiqihao.effective.java.chapter03;

/**
 * Always override toString.
 */
public class Item12 {
    final static class MobilePhone {
        private final String brand;

        MobilePhone(String brand) {
            this.brand = brand;
        }

        @Override
        public String toString() {
            return "This is a " + brand + " mobile phone.";
        }
    }

}