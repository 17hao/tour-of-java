package xyz.shiqihao.advanced.network.transport;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DatetimeServer {
    public static void main(String[] args) {
        final int port = 13;
        try (ServerSocket server = new ServerSocket(port)) {
            while (true) {
                try (Socket connection = server.accept();
                     Writer writer = new OutputStreamWriter(connection.getOutputStream())) {

                    writer.write(new Date().toString() + "\r\n");
                    writer.flush();
                } catch (IOException e) { // A client exception.
                    e.printStackTrace();
                }
            }
        } catch (IOException e) { // A server exception.
            e.printStackTrace();
        }
    }
}
