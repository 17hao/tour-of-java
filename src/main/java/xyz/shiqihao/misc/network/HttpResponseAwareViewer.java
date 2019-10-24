package xyz.shiqihao.misc.network;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpResponseAwareViewer {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://shiqihao.xyz");
            HttpURLConnection uc = (HttpURLConnection) url.openConnection();
            int responseCode = uc.getResponseCode();
            String responseMessage = uc.getResponseMessage();
            System.out.println("HTTP/1.x " + responseCode + " " + responseMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
