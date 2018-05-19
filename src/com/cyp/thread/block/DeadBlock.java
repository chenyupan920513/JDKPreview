package com.cyp.thread.block;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author pierre.chen
 * 死锁程序
 * @Date 18-5-18
 */
public class DeadBlock {

    static final A a = new A();
    static final B b = new B();

    static Runnable taskA = () -> {
        try {
            b.testB();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };
    static Runnable taskB = () -> {
        try {
            b.testB();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(taskA);
        executorService.submit(taskB);
    }


    static class A {
        public synchronized void testA() throws InterruptedException {
            Thread.sleep(50);
            b.testB();
        }
    }

    static class B {
        public synchronized void testB() throws InterruptedException {
            Thread.sleep(50);
            a.testA();
        }
    }
}
