package xyz.shiqihao.misc.network;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DatetimeServer {
    public static void main(String[] args) {
        final int port = 13;
        try (ServerSocket server = new ServerSocket(port);
             Socket connection = server.accept();
             Writer writer = new OutputStreamWriter(connection.getOutputStream())) {

            Date date = new Date();
            writer.write(date.toString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
