package xyz.shiqihao.thinking.in.java.chap09_interfaces.classprocessor;

public class Apply {
    public static void main(String[] args) {
        Processor upcase = new Upcase();
        System.out.println(upcase.process(upcase.name() + " return: " + "string"));
    }
}

class Processor {
    public String name() {
        return getClass().getSimpleName();
    }

    Object process(Object input) {
        return input;
    }
}

class Upcase extends Processor {
    @Override
    Object process(Object input) {
        return ((String) input).toUpperCase();
    }
}
