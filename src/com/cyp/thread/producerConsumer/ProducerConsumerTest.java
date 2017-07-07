package com.cyp.thread.producerConsumer;

/**
 * Created by Administrator on 2017/4/26.
 */
public class ProducerConsumerTest {

    public static void main(String[] args) {
        PublicResource resource = new PublicResource();
        new Thread(new ProducerThread(resource)).start();
        new Thread(new ConsumerThread(resource)).start();
        new Thread(new ProducerThread(resource)).start();
        new Thread(new ConsumerThread(resource)).start();
        new Thread(new ProducerThread(resource)).start();
        new Thread(new ConsumerThread(resource)).start();
    }
}
