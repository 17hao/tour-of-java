package xyz.shiqihao.misc.grpc.routeguide;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xyz.shiqihao.misc.grpc.routeguide.RouteGuideGrpc.RouteGuideImplBase;
import xyz.shiqihao.misc.grpc.routeguide.RouteGuideProto.Feature;
import xyz.shiqihao.misc.grpc.routeguide.RouteGuideProto.Point;

import java.util.ArrayList;
import java.util.Collection;

public class SimpleRouteGuideServer {
    private final Server server;

    public SimpleRouteGuideServer(int port, Collection<Feature> features) {
        server = ServerBuilder.forPort(port)
                .addService(new SimpleRouteGuideService(features))
                .build();
    }

    public void start() throws Exception {
        server.start();
        logger.info("Server started, listening on port 9999.");
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws Exception {
        Collection<Feature> features = new ArrayList<>();
        SimpleRouteGuideServer server = new SimpleRouteGuideServer(9999, features);
        server.start();
        server.blockUntilShutdown();
    }

    private static final Logger logger = LogManager.getLogger();

    private static class SimpleRouteGuideService extends RouteGuideImplBase {
        private final Collection<Feature> features;

        public SimpleRouteGuideService(Collection<Feature> features) {
            this.features = features;
        }

        @Override
        public void getFeature(Point request, StreamObserver<Feature> responseObserver) {
            responseObserver.onNext(checkFeature(request));
            responseObserver.onCompleted();
        }

        private Feature checkFeature(Point location) {
            for (Feature f : features) {
                if (f.getLocation().getLatitude() == location.getLatitude() &&
                        f.getLocation().getLongitude() == location.getLongitude()) {
                    return f;
                }
            }
            return Feature.newBuilder().setName("").setLocation(location).build();
        }
    }
}
