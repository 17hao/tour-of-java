package xyz.shiqihao.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class PutExample {
    public static void main(String[] args) throws IOException {
        Configuration c = HBaseConfiguration.create();
        Table table = ConnectionFactory.createConnection(c).getTable(TableName.valueOf("test"));
        Put put = new Put(Bytes.toBytes("row4"));
        put.addColumn(Bytes.toBytes("cf"), Bytes.toBytes("b"), Bytes.toBytes("val1"));
        table.put(put);
        table.close();
    }
}
