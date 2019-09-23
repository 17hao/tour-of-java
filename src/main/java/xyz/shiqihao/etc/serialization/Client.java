package xyz.shiqihao.etc.serialization;

import java.io.*;

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        serialize();
        recreate();
    }

    /**
     * Serializing an object and writing the data into temp.out
     * @throws IOException
     */
    private static void serialize() throws IOException {
        FileOutputStream fos = new FileOutputStream("temp.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        TestSerial ts = new TestSerial();
        oos.writeObject(ts);
        oos.flush();
        oos.close();
    }

    /**
     * Recreating a serialized object
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private static void recreate() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("temp.out");
        ObjectInputStream ois = new ObjectInputStream(fis);
        TestSerial ts = (TestSerial) ois.readObject(); // A cast to the correct type is required
        System.out.println("version is: " + ts.version);
    }
}
