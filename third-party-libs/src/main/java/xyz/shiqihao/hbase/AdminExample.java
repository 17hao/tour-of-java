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
        Configuration config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum", "shiqihao.xyz");
        Admin admin = ConnectionFactory.createConnection(config).getAdmin();
        ClusterMetrics cm = admin.getClusterMetrics();

        System.out.println("Cluster Metrics:\n------");
        System.out.println("Hbase version: " + cm.getHBaseVersion());
        System.out.println("Cluster id: " + cm.getClusterId());
        System.out.println("Master Server: " + cm.getMasterName());
        System.out.println("Servers: " + cm.getServersName());

        System.out.println("\nMaster Server Info\n------");
        ServerName master = admin.getMaster();
        System.out.println("Server Name: " + master.getServerName());
        System.out.println("Hostname: " + master.getHostname());
        System.out.println("Host and Port: " + master.getAddress());
        System.out.println("RPC Port: " + master.getPort());
        System.out.println("Start Code: " + master.getStartcode());

        System.out.println("\nRegion Info\n------");
        List<RegionInfo> regions = admin.getRegions(TableName.valueOf("test-table"));
        for (RegionInfo ri : regions) {
            System.out.println("Region Name: " + ri.getRegionNameAsString());
            System.out.println("Region ID: " + ri.getRegionId());
            System.out.println("Start Key: " + Bytes.toString(ri.getStartKey()));
            System.out.println("End Key: " + Bytes.toString(ri.getEndKey()));
            System.out.println("Encode Name: " + ri.getEncodedName());
        }
    }
}
