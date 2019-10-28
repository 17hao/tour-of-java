package xyz.shiqihao.misc.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
            for (int i = 1; ; i++) { // It's import that i > 0
                String headerKey = uc.getHeaderFieldKey(i);
                String headerValue = uc.getHeaderField(i);
                if (headerKey == null || headerValue == null) break;
                System.out.println(headerKey + ": " + headerValue);
            }
            System.out.println();
            try (InputStream is = uc.getInputStream();
                 BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

                for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
