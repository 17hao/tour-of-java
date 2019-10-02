package xyz.shiqihao.misc.bio;

import java.io.*;
import java.net.URL;
import java.util.Base64;

public class UrlDownload {
    public static void main(String[] args) throws Exception {
        // String h = "https://statics.growingio.com/media/20190730/3/1564542344548/0730img.jpeg";
        // OutputStream html = saveHtml(h);
        // System.out.println(html);
        String i = "https://statics.growingio.com/media/20190730/3/1564542344548/0730img.jpeggg";
        String image = "image.jpg";
        //saveImage(i, image);
        try {
            String result = getStringFromImage(i);
            System.out.println(result);
        } catch (IOException e) {
            System.out.println("not found");
        }
    }

    private static OutputStream saveHtml(String u) throws Exception {
        URL url = new URL(u);
        try (
                InputStream is = url.openStream();
                OutputStream os = new ByteArrayOutputStream();
        ) {
            byte[] byteChunk = new byte[2048];
            int n;
            while ((n = is.read(byteChunk)) != -1) {
                os.write(byteChunk, 0, n);
            }
            return os;
        }
    }

    private static void saveImage(String u, String destinationFile) throws IOException {
        URL url = new URL(u);
        try (
                InputStream is = url.openStream();
                OutputStream os = new FileOutputStream(destinationFile);
        ) {
            byte[] byteChunk = new byte[2048];
            int n;
            while ((n = is.read(byteChunk)) != -1) {
                os.write(byteChunk, 0, n);
            }
        }
    }

    private static String getStringFromImage(String u) throws Exception {
        URL url = new URL(u);
        try (
                InputStream is = url.openStream();
                ByteArrayOutputStream os = new ByteArrayOutputStream()
        ) {
            byte[] byteChunk = new byte[1024];
            int n;
            while ((n = is.read(byteChunk)) != -1) {
                os.write(byteChunk, 0, n);
            }
            return Base64.getEncoder().encodeToString(os.toByteArray());
        }
    }
}
