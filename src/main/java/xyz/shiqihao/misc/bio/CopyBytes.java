package xyz.shiqihao.misc.bio;

import java.io.*;

public class CopyBytes {
    public static void main(String[] args) {
        try (
                InputStream is = new FileInputStream(new File("./src/main/resources/input.txt"));
                InputStream inputStream = new BufferedInputStream(is);
                OutputStream outputStream = new FileOutputStream(new File("./src/main/resources/output.txt"))
        ) {
            int n;
            while ((n = inputStream.read()) != -1) {
                outputStream.write(n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
