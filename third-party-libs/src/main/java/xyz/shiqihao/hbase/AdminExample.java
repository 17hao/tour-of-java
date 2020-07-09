package xyz.shiqihao.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.ClusterMetrics;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.ServerName;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.RegionInfo;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.List;

public class AdminExample {
    public static void main(String[] args) throws IOException {
        Configuration c = HBaseConfiguration.create();
        Admin admin = ConnectionFactory.createConnection(c).getAdmin();
        ClusterMetrics cm = admin.getClusterMetrics();
        System.out.println("Cluster Metrics:\n------");
        System.out.println("Hbase version: " + cm.getHBaseVersion());
        System.out.println("Cluster id: " + cm.getClusterId());
        System.out.println("Servers: " + cm.getServersName());

        System.out.println("\nServer Info\n------");
        for (ServerName server : cm.getServersName()) {
            System.out.println("Server Name: " + server.getServerName());
            System.out.println("Hostname: " + server.getHostname());
            System.out.println("Host and Port: " + server.getHostAndPort());
            System.out.println("RPC Port: " + server.getPort());
            System.out.println("Start Code: " + server.getStartcode());
        }

        System.out.println("\nRegion Info\n------");
        List<RegionInfo> regions = admin.getRegions(TableName.valueOf("test"));
        for (RegionInfo ri : regions) {
            System.out.println("Region Name: " + ri.getRegionNameAsString());
            System.out.println("Region ID: " + ri.getRegionId());
            System.out.println("Start Key: " + Bytes.toString(ri.getStartKey()));
            System.out.println("End Key: " + Bytes.toString(ri.getEndKey()));
            System.out.println("Encode Name: " + ri.getEncodedName());
        }
    }
}
