package com.cyp.thread.countDown;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;

/**
 * @Author pierre.chen
 * @Date 18-4-28
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

        Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread() + " >>> start ");
                    Thread.sleep(finalI * 1000);
                    System.out.println(Thread.currentThread() + " >>> start " + System.currentTimeMillis());
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread() + " >>> end " + System.currentTimeMillis());

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
