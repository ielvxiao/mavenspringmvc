package com.example.util;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author lvxiao
 * @Date 2018/11/5 17:00
 * @Description: zookeeper java客户端测试
 * @Version V1.0
 */
public class AdminClient implements Watcher {

    private ZooKeeper zk;

    private void startZk() throws IOException {
        zk = new ZooKeeper("35.201.207.143:2181", 5000, this);
    }

    @Override
    public void process(WatchedEvent event) {
        System.out.println("event: " + event);
    }

    private void listState() throws KeeperException, InterruptedException {
        try {
            Stat stat = new Stat();
            byte[] masterData = zk.getData("/test", false, stat);
            Date startDate = new Date(stat.getCtime());
            System.out.println("test: " + new String(masterData) + " since " + startDate);
        } catch (KeeperException.NoNodeException e) {
            System.out.println("no master");
        }

        System.out.println("workers: \n");
        for (String worker : zk.getChildren("/workers", false)) {
            byte[] data = zk.getData("/workers/" + worker, false, null);
            String state = new String(data);
            System.out.println("worker: " + state);
        }

        // ...
    }

    public static void main(String[] args) throws IOException {
        String hostPort = "35.201.207.143:2181";
        String zpath = "/";
        List<String> zooChildren = new ArrayList<String>();
        ZooKeeper zk = new ZooKeeper(hostPort, 2000, null);
        if (zk != null) {
            try {
                zooChildren = zk.getChildren(zpath, false);
                System.out.println("Znodes of '/': ");
                for (String child: zooChildren) {
                    //print the children
                    System.out.println(child);
                }
            } catch (KeeperException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
