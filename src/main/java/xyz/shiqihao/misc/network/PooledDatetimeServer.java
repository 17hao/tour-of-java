package xyz.shiqihao.misc.network;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PooledDatetimeServer {
    public static void main(String[] args) {
        final int port = 13;
        ExecutorService pool = Executors.newFixedThreadPool(50);
        try (ServerSocket server = new ServerSocket(port)) {
            while (true) {
                try {
                    pool.submit(new Datetime(server.accept()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Datetime implements Runnable {
    private Socket connection;

    Datetime(Socket connection) {
        this.connection = connection;
    }

    @Override
    public void run() {
        try {
            Writer writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(new Date().toString() + "\r\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
