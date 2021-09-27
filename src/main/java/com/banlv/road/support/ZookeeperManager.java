package com.banlv.road.support;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Random;

/**
 * @author ：Lambert Wang
 * @date ：Created in 2021/2/9 17:41
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
public class ZookeeperManager implements Watcher {
    Logger logger = LoggerFactory.getLogger(ZookeeperManager.class.getName());
    ZooKeeper zk;
    String hostPort;
    String serverId = "";

    public ZookeeperManager(String hostPort) {
        this.hostPort = hostPort;
    }

    public void startZk() {
        try {
            zk = new ZooKeeper(hostPort, 15000, this);
            Random random = new Random();
            this.serverId = Integer.toHexString(random.nextInt());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void runForMaster() {
        try {
            zk.create("/master1", this.serverId.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            Thread.sleep(5000);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.print(watchedEvent);
    }

    public void stopZk() throws InterruptedException {
        zk.close();
    }

    public void bootstrap() {
        createParent("/workers", new byte[0]);
        createParent("/assign", new byte[0]);
        createParent("/tasks", new byte[0]);
        createParent("/status", new byte[0]);
    }

    static boolean idLeader;
    AsyncCallback.StringCallback masterCreateCallback = new AsyncCallback.StringCallback() {
        @Override
        public void processResult(int i, String s, Object o, String s1) {
            switch (KeeperException.Code.get(i)) {
                case CONNECTIONLOSS:
                    runForMaster();
                case OK:
                    idLeader = true;
                default:
                    idLeader = false;

            }
        }
    };

    AsyncCallback.StringCallback createParentCallback = new AsyncCallback.StringCallback() {
        @Override
        public void processResult(int rc, String path, Object ctx, String name) {
            switch (KeeperException.Code.get(rc)) {
                case CONNECTIONLOSS:
                    createParent(path, (byte[]) ctx);
                    break;
                case OK:
                    logger.info("Parent created");
                    break;
                case NODEEXISTS:
                    logger.warn("Parent already exists: " + path);
                    break;
                default:
                    logger.error("Something went wrong: ", KeeperException.create(KeeperException.Code.get(rc), path));

            }
        }
    };

    public String getData() throws KeeperException, InterruptedException {
        byte[] data = zk.getData("/master1", false, new Stat());
        return new String(data);
    }

    public void createParent(String path, byte[] data) {
        zk.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT, createParentCallback, data);
    }

    public String queueCommand(String command) throws Exception {
        String name = "";
        while (true) {
            try {
                name = zk.create("/tasks/task-", command.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
                return name;
            } catch (KeeperException.NodeExistsException e) {
                throw new Exception("already running");
            } catch (KeeperException.ConnectionLossException e) {
                e.printStackTrace();
                break;
            }
        }
        return name;
    }

    public void getPingData() {

    }

    public static void main(String[] args) {
        ZookeeperManager zooKeeper = new ZookeeperManager("192.168.196.135");
        zooKeeper.startZk();
        zooKeeper.runForMaster();

        try {
            String masterData = zooKeeper.getData();
            System.out.println("master data is " + masterData);
            String childNodeName = zooKeeper.queueCommand("test-start");
            System.out.println("node name is " + childNodeName);
            zooKeeper.stopZk();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
