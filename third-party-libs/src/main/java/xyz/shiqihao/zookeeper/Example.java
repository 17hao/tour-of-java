package xyz.shiqihao.zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;

/**
 * zk client example
 *
 * @since 2021-1-1 23:30
 */
public class Example {
    private static final Properties conf = new Properties();

    static {
        try {
            conf.load(Example.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class MyWatcher implements Watcher {
        @Override
        public void process(WatchedEvent event) {
            if (event.getState().equals(Event.KeeperState.SyncConnected)) {
                System.out.println("zk is in sync connected.");
            }
        }
    }

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zk = new ZooKeeper(conf.getProperty("zookeeper.hosts"), 30000, null);
        System.out.println(new String(zk.getData("/2021/12/23", false, zk.exists("/2021/12/23", false))));

        zk.create(
                "/2021/12/23/003",
                LocalDateTime.now().toString().getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT,
                zk.exists("/2021/12/23", false)
        );
        zk.close();
    }
}
