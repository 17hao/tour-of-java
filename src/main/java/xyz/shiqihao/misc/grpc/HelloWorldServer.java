package xyz.shiqihao.misc.grpc;

import com.google.protobuf.RpcCallback;
import com.google.protobuf.RpcController;
import io.grpc.Server;

import java.util.logging.Logger;

public class HelloWorldServer {
    private static final Logger logger = Logger.getLogger(HelloWorldServer.class.getName());

    private Server server;

    private void start() {
        int port = 50051;
    }

}
