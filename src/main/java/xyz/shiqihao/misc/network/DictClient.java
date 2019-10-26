package xyz.shiqihao.misc.network;

import com.google.common.base.Charsets;

import java.io.*;
import java.net.Socket;

public class DictClient {
    private static final String SERVER = "dict.org";
    private static final int PORT = 2628;
    private static final int TIMEOUT = 15000;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER, PORT);
            socket.setSoTimeout(TIMEOUT);
            OutputStream out = socket.getOutputStream();
            Writer writer = new BufferedWriter(new OutputStreamWriter(out, Charsets.UTF_8));
            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, Charsets.UTF_8));
            lookUp(writer, reader);
            writer.write("quit\r\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void lookUp(Writer writer, BufferedReader reader) {
        try {
            writer.write("define fd-eng-lat gold\r\n");
            writer.flush();
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                if (line.startsWith("552 ")) {
                    System.out.println("Not definition");
                    return;
                } else if (line.startsWith("250 ")) {
                    return;
                } else if (line.matches("\\d.*") || line.trim().equals(".")) {
                    continue;
                } else {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
