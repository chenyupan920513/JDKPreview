package com.cyp.thread.producerConsumer;

/**
 * Created by Administrator on 2017/4/26.
 */
public class ConsumerThread implements Runnable {

    private PublicResource resource;

    public ConsumerThread(PublicResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource.decreace();
        }
    }
}

