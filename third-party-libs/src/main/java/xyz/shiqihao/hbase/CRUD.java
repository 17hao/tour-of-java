package xyz.shiqihao.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 * HBase crud
 *
 * @since 2020-1-2 Saturday
 */
public class CRUD {
    public static void main(String[] args) throws IOException {
        Configuration config = HBaseConfiguration.create();
        config.addResource("hbase-site.xml");
        Admin admin = ConnectionFactory.createConnection(config).getAdmin();
        TableName testTable = TableName.valueOf("test-table");

        // create table
        admin.createTable(TableDescriptorBuilder
                .newBuilder(testTable)
                .setColumnFamily(ColumnFamilyDescriptorBuilder.newBuilder("col-fam-1".getBytes()).build())
                .setColumnFamily(ColumnFamilyDescriptorBuilder.newBuilder("col-fam-2".getBytes()).build())
                .build());

        Table table = admin.getConnection().getTable(testTable);

        Put put = new Put(Bytes.toBytes("row-1"));
        put.addColumn(Bytes.toBytes("col-fam-1"), Bytes.toBytes("key-1"), Bytes.toBytes("value-1"));
        table.put(put);

        Get get = new Get(Bytes.toBytes("row-1"));
        System.out.println(new String(table.get(get)
                .getValue(Bytes.toBytes("col-fam-1"), Bytes.toBytes("key-1"))));
    }
}
