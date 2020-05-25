package xyz.shiqihao.hadoop.ch06;

import org.apache.hadoop.conf.Configuration;

public class Test1 {
    public String getColor() {
        Configuration conf = new Configuration();
        conf.addResource("hadoop-conf/configuration-1.xml");
        return conf.get("color");
    }
}
