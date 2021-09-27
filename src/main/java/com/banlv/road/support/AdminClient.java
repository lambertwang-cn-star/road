package com.banlv.road.support;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.Date;

/**
 * @author ：Lambert Wang
 * @date ：Created in 2021/6/29 18:09
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
public class AdminClient implements Watcher {
    String hostPort;
    ZooKeeper zk;

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println(watchedEvent);
    }

    AdminClient(String hostPort) { this.hostPort = hostPort; }

    void start() throws Exception {
        zk = new ZooKeeper(hostPort, 15000, this);
    }

    public void listState() throws KeeperException, InterruptedException {
        try{
            Stat stat = new Stat();
            byte[] masterData = zk.getData("/master", false, stat);
            Date startDate = new Date(stat.getCtime());
            System.out.println("Master: " + new String(masterData) + "since " + startDate);
        } catch (KeeperException.NoNodeException e) {
            System.out.println("No master");
        }

        for(String w: zk.getChildren("/workers", false)) {
            byte[] workData = zk.getData("workers" + w, false, null);
            String state = new String(workData);
            System.out.println("worker: " + w + ", data:" +state);
        }
    }

}
