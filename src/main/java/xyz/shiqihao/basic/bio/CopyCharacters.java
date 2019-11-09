package xyz.shiqihao.basic.bio;

import java.io.*;

public class CopyCharacters {
    public static void main(String[] args) {
        try (
                Reader reader = new FileReader(new File("./src/main/resources/input.txt"));
                Writer writer = new FileWriter(new File("./src/main/resources/char-output.txt"))
        ) {
            int n;
            while ((n = reader.read()) != -1) {
                writer.write(n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
