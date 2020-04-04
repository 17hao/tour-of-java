package xyz.shiqihao.misc.netty.echo.bio;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Single thread blocking I/O: block thread until last connection closed.
 */
public class EchoServer {
    private static final Logger logger = LogManager.getLogger();

    private final ExecutorService executor = Executors.newFixedThreadPool(124);

    private void singleThreadRun() {
        try {
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(9000));
            while (!Thread.interrupted()) {
                Socket socket = serverSocket.accept();
                logger.info("client connected: " + socket);
                new SocketHandler(socket).handleRequest();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private void multiThreadRun() {
//        try {
//            ServerSocket serverSocket = new ServerSocket();
//            serverSocket.bind(new InetSocketAddress(9000));
//            while (!Thread.interrupted()) {
//                executor.execute(new SocketHandler(serverSocket.accept()));
//            }
//        } catch (IOException e) {
//            logger.error(e.getMessage());
//        }
//    }

    public static void main(String[] args) {
        EchoServer server = new EchoServer();
        server.singleThreadRun();
        //server.multiThreadRun();
    }

    private static class SocketHandler {
        private final Socket socket;

        public SocketHandler(Socket socket) {
            this.socket = socket;
        }

        public void handleRequest() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                for (String s = reader.readLine(); s != null; s = reader.readLine()) {
                    logger.info(socket.getRemoteSocketAddress() + " said: " + s);
                    writer.write(s);
                    writer.newLine();
                    writer.flush();
                    if (s.equals("exit")) {
                        socket.close();
                    }
                }
            } catch (IOException e) {
                logger.error(e);
            }
            // try (
            //         BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //         BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
            // ) {
            //     StringBuilder builder = new StringBuilder();
            //     for (int i = reader.read(); (char) i != '\n'; i = reader.read()) {
            //         builder.append((char) i);
            //     }
            //     logger.info("===> " + builder.toString());
            //     writer.write(builder.toString() + "\n");
            //     writer.flush();
            // } catch (IOException e) {
            //     logger.error(e.getMessage());
            // }
        }
    }
}
