package com.cyp.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2017/5/27.
 */
public class LockTest {
    public static void main(String[] args) {
        final Outputter1 output = new Outputter1();
        new Thread(() -> output.output("zhangsan")).start();
        new Thread(() -> output.output("lisi")).start();
    }
}
class Outputter1 {
    private Lock lock = new ReentrantLock();// 锁对象
    public void output(String name) {
        lock.lock();// 得到锁
        try {
            for(int i = 0; i < name.length(); i++) {
                System.out.print(name.charAt(i));
            }
        } finally {
            lock.unlock();// 释放锁
        }
    }
}
