package com.wen.lock;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author ：wenbo
 * @date ：Created in 2021/9/7 10:12 下午
 * @description：
 * @modified By：
 * @version: $
 */
public class ZkLock implements Lock {

    private ThreadLocal<ZooKeeper> zk = new ThreadLocal<>();
    private ThreadLocal<String> CURRENT_NODE = new ThreadLocal<>();
    private String LOCK_NAME = "/LOCK";

    private void  init() {
        if(zk.get() == null){
            try {
                zk.set(new ZooKeeper("localhost:2181", 3000,new Watcher() {
                    @Override
                    public void process(WatchedEvent event) {

                    }
                }));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void lock() {
        init();
        if(tryLock()){
            System.out.println("拿到锁了");
        }

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        String nodeName = LOCK_NAME + "/zk_";

        try {
            CURRENT_NODE.set(zk.get().create(nodeName,new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL));
            List<String> list = zk.get().getChildren(LOCK_NAME, false);
            Collections.sort(list);
            System.out.println(list);

            String minNode = list.get(0);
            if((LOCK_NAME + "/" + minNode).equals(CURRENT_NODE.get())){
                return true;
            }else {
                Integer currentIndex = list.indexOf(CURRENT_NODE.get().substring(CURRENT_NODE.get().lastIndexOf("/") + 1));
                String preNodeName = list.get(currentIndex - 1);
                final CountDownLatch cd = new CountDownLatch(1);
                zk.get().exists(LOCK_NAME + "/" + preNodeName, new Watcher() {
                    @Override
                    public void process(WatchedEvent event) {
                        if(Event.EventType.NodeDeleted.equals(event.getType())){
                            cd.countDown();
                            System.out.println(Thread.currentThread().getName() + "锁唤醒了！");
                        }
                    }
                });
                System.out.println(Thread.currentThread().getName() + "等待锁！");
            }

        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        try {
            zk.get().delete(CURRENT_NODE.get(), -1);
            CURRENT_NODE.remove();
            zk.get().close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
