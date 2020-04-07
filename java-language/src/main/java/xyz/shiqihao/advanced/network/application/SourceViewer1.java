package xyz.shiqihao.advanced.network.application;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class SourceViewer1 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://shiqihao.xyz");
            URLConnection uc = url.openConnection();
            try (InputStream is = uc.getInputStream();
                 Reader reader = new InputStreamReader(is);
                 OutputStream out = new FileOutputStream(new File("./src/main/resources/Source.html"));
                 BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out))) {

                for (int ch = reader.read(); ch != -1; ch = reader.read()) {
                    writer.write(ch);
                    writer.flush();
                }
                System.out.println("Success!");
            }
        } catch (MalformedURLException e) {
            System.out.println("URL is not a pareable URL");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
