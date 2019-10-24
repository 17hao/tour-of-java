package xyz.shiqihao.misc.network;

import java.io.*;
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
                 Reader reader = new InputStreamReader(is);
                 Reader bufferedReader = new BufferedReader(reader)) {
                int ch;
                while ((ch = bufferedReader.read()) != -1) {
                    System.out.print((char) ch);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
