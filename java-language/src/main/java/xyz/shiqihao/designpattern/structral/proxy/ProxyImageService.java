package xyz.shiqihao.designpattern.structral.proxy;

public class ProxyImageService implements ImageService {
    private RealImageService is;
    private String filename;

    public ProxyImageService(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        System.out.println("proxy obj");
        if (is == null) {
            is = new RealImageService(filename);
        }
        is.display();
    }
}
