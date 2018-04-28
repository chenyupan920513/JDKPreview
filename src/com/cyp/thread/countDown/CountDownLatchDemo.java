package com.cyp.thread.countDown;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author pierre.chen
 * @Date 18-4-28
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        test1();
        test2();


    }

    static void test1() throws InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            try {
                int finalI = i;
                es.submit(() -> {
                    try {
                        Thread.sleep(finalI * 100);
                        System.out.println("ooooooooooooooooooooooooooo");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            } finally {
                countDownLatch.countDown();
            }
        }
        countDownLatch.await();
        System.out.println("first step is over!");


    }

    static void test2() throws InterruptedException {
        ExecutorService es2 = Executors.newCachedThreadPool();
        java.util.concurrent.CountDownLatch countDownLatch2 = new java.util.concurrent.CountDownLatch(10);
        try {
            for (int j = 0; j < 10; j++) {
                int finalJ = j;
                es2.submit(() -> {
                    try {
                        Thread.sleep(finalJ * 100);
                        System.out.println("llllllllllllllllllllllllll");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        } finally {
            countDownLatch2.countDown();
        }
        countDownLatch2.await();
        System.out.println("second step is over!");

    }
}
