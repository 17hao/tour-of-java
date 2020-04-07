package xyz.shiqihao.consul;

import com.orbitz.consul.Consul;
import com.orbitz.consul.HealthClient;
import com.orbitz.consul.model.health.ServiceHealth;

import java.util.List;

public class HealthCheckClient {
    public static void main(String[] args) {
        HealthClient client = Consul.newClient().healthClient();
        List<ServiceHealth> nodes = client.getHealthyServiceInstances("web").getResponse();
        System.out.println(nodes);
    }
}
