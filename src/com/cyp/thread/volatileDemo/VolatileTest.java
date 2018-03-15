package com.cyp.thread.volatileDemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author pierre
 * 18-3-14
 * volatile 变量自增运算测试
 */
public class VolatileTest {

    public static volatile int race = 0;
//    public static AtomicInteger race = new AtomicInteger(0);

    public static void increase() {
        race++;// 非原子操作
//        race.incrementAndGet();// 原子操作
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    increase();
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            threads[i].start();
        }
        while (Thread.activeCount() > 1)
            Thread.yield();

        System.out.println(race);
    }
}
