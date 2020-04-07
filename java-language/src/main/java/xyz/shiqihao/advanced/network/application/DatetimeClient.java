package xyz.shiqihao.advanced.network.application;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class DatetimeClient {
    public static void main(String[] args) {
        final String localTimeServer = "localhost";
        final String remoteTimeServer = "time.nist.gov";
        try (Socket socket = new Socket(localTimeServer, 13);
             InputStream is = new BufferedInputStream(socket.getInputStream())) {

            StringBuilder sb = new StringBuilder();
            for (int ch = is.read(); ch != -1; ch = is.read()) {
                sb.append((char) ch);
            }
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
