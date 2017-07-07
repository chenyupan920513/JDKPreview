package com.cyp.thread.synchronize;

/**
 * Created by Administrator on 2017/4/26.
 */
public class Sync {

    public synchronized void test() {
        System.out.println("test开始..");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test结束..");
    }

}
