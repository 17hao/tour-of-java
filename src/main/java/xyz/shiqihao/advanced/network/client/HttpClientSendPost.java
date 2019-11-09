package xyz.shiqihao.advanced.network.client;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClientSendPost {
    public static void main(String[] args) {
        HttpClientSendPost client = new HttpClientSendPost();
        System.out.println(client.sendRequest());
    }

    private String sendRequest() {
        try {
            URL url = new URL("http://shiqihao.xyz:9000/users");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setConnectTimeout(3000);
            connection.setReadTimeout(30000);
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.connect();
            try (OutputStream os = connection.getOutputStream()) {
                String requestBody =
                        new Gson().toJson(new RequestBody.Builder("sqh", "123").build());
                os.write(requestBody.getBytes());
                os.flush();
            }
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader reader =
                             new BufferedReader(new InputStreamReader(connection.getInputStream()))) {

                    StringBuilder sb = new StringBuilder();
                    for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                        sb.append(line);
                    }
                    return sb.toString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

class RequestBody {

    private final String name; // MUST
    private final int age; // OPTION
    private final String city; //OPTION
    private final String password; // MUST

    static class Builder {
        private final String name;
        private int age;
        private String city;
        private final String password;

        Builder(String name, String password) {
            this.name = name;
            this.password = password;
        }

        Builder setAge(int age) {
            return this;
        }

        Builder setCity(String city) {
            return this;
        }

        RequestBody build() {
            return new RequestBody(this);
        }
    }

    private RequestBody(Builder builder) {
        name = builder.name;
        age = builder.age;
        city = builder.city;
        password = builder.password;
    }
}
