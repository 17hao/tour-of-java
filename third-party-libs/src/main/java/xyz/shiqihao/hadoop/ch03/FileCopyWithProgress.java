package xyz.shiqihao.hadoop.ch03;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.*;
import java.net.URI;

/**
 * Copy local file to hdfs
 */
public class FileCopyWithProgress {
    public static void main(String[] args) throws IOException {
        String src = args[0], dst = args[1];

        InputStream in = new BufferedInputStream(new FileInputStream(src));

        Configuration conf = new Configuration();

        FileSystem fs = FileSystem.get(URI.create(dst), conf);

        OutputStream out = fs.create(new Path(dst), () -> System.out.println("."));

        IOUtils.copyBytes(in, out, 4096);
    }
}
