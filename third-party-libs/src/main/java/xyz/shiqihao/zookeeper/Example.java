package xyz.shiqihao.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * zk client example
 *
 * @since 2021-1-1 23:30
 */
public class Example {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        String hostPort = "shiqihao.xyz:2181";
        Watcher watcher = new MyWatcher();
        ZooKeeper zk = new ZooKeeper(hostPort, 30000, watcher);
        Stat stat = zk.exists("/test-node", watcher);
//        zk.create("/java-client", "java".getBytes(), ZooDefs.Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT);
        String data = new String(zk.getData("/test-node", watcher, stat));
        System.out.println(data);
    }
}

class MyWatcher implements Watcher {
    @Override
    public void process(WatchedEvent event) {
        if (event.getState().equals(Event.KeeperState.SyncConnected)) {
            System.out.println("zk is in sync connected.");
        }
    }
}
