package xyz.shiqihao.effective.java.chapter09;

/**
 * 关于local variable的几点建议, 都是围绕着最小化作用域.
 * <p>
 * ① 只有在用到局部变量时才去声明它, 如果在代码顶部声明一堆局部变量会让代码很难读.
 * ② 几乎所有的局部变量声明时都应该赋予初始化的值.
 * ③ 尽可能用for而不是while, 因为while需要在while代码块外部声明局部变量, 当另一个while语句要用到时可能会出错.
 */
public class Item57 {
    public static void main(String[] args) {
        int i = 0;
        while (i < 2) {
            System.out.println("printing until 2");
            i++;
        }
        while (i < 4) {
            System.out.println("printing until 4");
            i++;
        }

        for (int j = 0; j < 6; j++) {
            System.out.println("printing until 6");
        }

        for (int j = 0; j < 8; j++) {
            System.out.println("printing until 8");
        }
    }
}
