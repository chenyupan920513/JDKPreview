package com.cyp.thread.block;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author pierre.chen
 * @Date 18-5-18
 */
public class BlockTest {

    public static final BlockTest blockTest = new BlockTest();

    public synchronized static void test1() throws InterruptedException {
        System.out.println("run test1 :" + System.currentTimeMillis());
        Thread.sleep(1000);
        System.out.println("test1 end :" + System.currentTimeMillis());
    }


    public static void test2() throws InterruptedException {
        System.out.println("run test2 :" + System.currentTimeMillis());
        System.out.println(System.currentTimeMillis());
        System.out.println("test2 end :" + System.currentTimeMillis());
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();

        es.submit(() -> {
            try {
                System.out.println("test1 start : " + System.currentTimeMillis());
                blockTest.test1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        es.submit(() -> {
            try {
                System.out.println("test2 start : " + System.currentTimeMillis());
                blockTest.test2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
