package xyz.shiqihao.misc.network;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class HttpHeadAwareViewer {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://shiqihao.xyz");
            URLConnection uc = url.openConnection();
            System.out.println("Content-Type is: " + uc.getContentType());
            System.out.println("Content-Length is: " + uc.getContentLength());
            System.out.println("Content-Encoding is: " + uc.getContentEncoding());
            System.out.println("Date is: " + new Date(uc.getDate()));
            System.out.println("Expiration is: " + uc.getExpiration());
            System.out.println("Last-Modified is: " + new Date(uc.getLastModified()));
        } catch (MalformedURLException e) {
            System.out.println("URL is not a parseable URL");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
