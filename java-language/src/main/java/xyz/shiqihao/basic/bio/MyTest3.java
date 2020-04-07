package xyz.shiqihao.basic.bio;

import java.io.*;

/**
 * copy by line.
 */
public class MyTest3 {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new FileReader("F:\\javacode\\src\\xyz.shiqihao.etc\\io\\xanadu.txt"));
                PrintWriter writer = new PrintWriter(new FileWriter("bufferedcharacteroutput.txt"))
        ) {
            String l;
            while ((l = reader.readLine()) != null) {
                writer.println(l);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
