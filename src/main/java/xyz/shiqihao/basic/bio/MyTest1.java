package xyz.shiqihao.basic.bio;

import java.io.*;

/**
 * copy by byte
 * inputstream/outputstream
 */
public class MyTest1 {
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
