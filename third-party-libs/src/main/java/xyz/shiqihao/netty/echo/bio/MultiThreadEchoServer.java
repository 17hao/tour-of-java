package xyz.shiqihao.netty.echo.bio;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * multiple thread blocking io
 */
public class MultiThreadEchoServer {
    private static final Logger logger = LogManager.getLogger();

    private static final Executor executor = Executors.newFixedThreadPool(10);

    private void run() {
        try {
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(9000));
            logger.info("server is started." + serverSocket);
            while (!Thread.interrupted()) {
                executor.execute(new SocketHandler(serverSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class SocketHandler implements Runnable {
        private final ServerSocket serverSocket;

        SocketHandler(ServerSocket serverSocket) {
            this.serverSocket = serverSocket;
        }

        @Override
        public void run() {
            try {
                Socket socket = serverSocket.accept();
                logger.info("client connected." + socket);
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                for (String s = reader.readLine(); s != null; s = reader.readLine()) {
                    if (s.equals("quit") || s.equals("exit")) {
                        logger.info("client disconnected." + socket);
                        reader.close();
                        writer.close();
                        break;
                    }
                    writer.write(s);
                    writer.newLine();
                    writer.flush();
                }
            } catch (Exception e) {
                logger.error(e);
            }
        }
    }

    public static void main(String[] args) {
        MultiThreadEchoServer server = new MultiThreadEchoServer();
        server.run();
    }
}
