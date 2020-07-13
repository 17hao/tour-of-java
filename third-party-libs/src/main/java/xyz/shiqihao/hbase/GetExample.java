package xyz.shiqihao.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HConstants;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class GetExample {
    public static void main(String[] args) throws IOException {
        Configuration c = HBaseConfiguration.create();
        c.set(HConstants.ZOOKEEPER_QUORUM, "shiqihao.xyz");
        c.set(HConstants.ZOOKEEPER_CLIENT_PORT, "2181");
        Table table = ConnectionFactory.createConnection(c).getTable(TableName.valueOf("test"));
        Get get = new Get(Bytes.toBytes("row-1"));
        get.addColumn(Bytes.toBytes("cf"), Bytes.toBytes("a"));
        Result result = table.get(get);
        byte[] val = result.getValue(Bytes.toBytes("cf"), Bytes.toBytes("a"));
        System.out.println(Bytes.toString(val));
        table.close();
    }
}
