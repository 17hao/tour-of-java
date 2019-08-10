package miscellaneous.bio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) {
        try (
                FileInputStream inputStream = new FileInputStream("F:\\javacode\\src\\etc\\io\\xanadu.txt");
                FileOutputStream outputStream = new FileOutputStream("outagin.txt")
        ) {
            int n;
            while ((n = inputStream.read()) != -1) {
                outputStream.write(n);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
