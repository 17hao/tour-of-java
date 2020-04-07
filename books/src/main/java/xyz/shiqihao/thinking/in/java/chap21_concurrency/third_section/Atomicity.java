package xyz.shiqihao.thinking.in.java.chap21_concurrency.third_section;

public class Atomicity {
    int i;

    void f1() {
        i++;
    }

    void f2() {
        i += 3;
    }
}
