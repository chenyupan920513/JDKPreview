package com.cyp.thread.synchronize;

/**
 * Created by Administrator on 2017/4/26.
 */
public class MyThread extends Thread {
    public static  Sync sync = new Sync();
    public void run() {

        sync.test();
    }
}
