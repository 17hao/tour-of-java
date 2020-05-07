package xyz.shiqihao;

import com.google.gson.Gson;
import org.apache.commons.codec.digest.HmacUtils;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;

public class Hmac {
    public static void main(String[] args) {
        Map<String, String> payload = new HashMap<>();
        String secret = "secret";
        System.out.println(sign(payload, secret));
        System.out.println(OffsetDateTime.now());
    }

    /**
     *
     */
    static String sign(Map<String, String> payload, String secret) {
        String str = new Gson().toJson(payload);
        return HmacUtils.hmacSha256Hex(str, secret);
    }
}
