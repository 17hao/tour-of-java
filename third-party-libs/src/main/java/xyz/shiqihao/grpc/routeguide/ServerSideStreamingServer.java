package xyz.shiqihao.grpc.routeguide;

import io.grpc.stub.StreamObserver;
import xyz.shiqihao.grpc.routeguide.RouteGuideGrpc.RouteGuideImplBase;
import xyz.shiqihao.grpc.routeguide.RouteGuideProto.Feature;
import xyz.shiqihao.grpc.routeguide.RouteGuideProto.Rectangle;

import java.util.Collection;

public class ServerSideStreamingServer {
    private static class ServerSideStreamingService extends RouteGuideImplBase {
        private final Collection<Feature> features;

        public ServerSideStreamingService(Collection<Feature> features) {
            this.features = features;
        }

        @Override
        public void listFeatures(Rectangle request, StreamObserver<Feature> responseObserver) {
            int left = Integer.min(request.getLo().getLongitude(), request.getHi().getLongitude());
            int right = Integer.max(request.getLo().getLongitude(), request.getHi().getLongitude());
            int top = Integer.max(request.getLo().getLatitude(), request.getHi().getLatitude());
            int bottom = Integer.min(request.getLo().getLatitude(), request.getHi().getLatitude());
            for (Feature f : features) {
                if (!RouteGuideUtil.exists(f)) {
                    continue;
                }
                int lat = f.getLocation().getLatitude();
                int lon = f.getLocation().getLongitude();
                if (lon >= left && lon <= right && lat >= bottom && lat <= top) {
                    responseObserver.onNext(f);
                }
            }
            responseObserver.onCompleted();
        }
    }
}
