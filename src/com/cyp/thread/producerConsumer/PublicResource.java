package com.cyp.thread.producerConsumer;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2017/4/26.
 */
public class PublicResource {

    private AtomicInteger number = new AtomicInteger();

    /**
     * 增加公共资源
     */
    public synchronized void increace() {
/*        while (number != 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        number.getAndIncrement();
        System.out.println("生产"+Thread.currentThread().getName() +"===>>>"+ number);
        notify();
    }

    /**
     * 减少公共资源
     */
    public synchronized void decreace() {
        while (number.intValue() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number.getAndDecrement();
        System.out.println("消费者"+Thread.currentThread().getName() +"===>>>"+ number);
        notify();
    }
}
