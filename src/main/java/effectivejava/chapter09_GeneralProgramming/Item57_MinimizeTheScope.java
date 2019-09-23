package effectivejava.chapter09_GeneralProgramming;

/**
 * To minimize the scope of variables, for is better than while
 */
public class Item57_MinimizeTheScope {
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
