package xyz.shiqihao.designpattern.structral.proxy;

public class RealImageService implements ImageService {
    private String filename;

    public RealImageService(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    @Override
    public void display() {
        System.out.println("Displaying " + filename);
    }

    void loadFromDisk() {
        System.out.println("Loading " + filename + " from disk.");
    }
}
