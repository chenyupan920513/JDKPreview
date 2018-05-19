package com.cyp.thread.block;


import java.util.concurrent.*;

public class Counter {

    public volatile static int count = 0;

    public static void inc() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
        System.out.println(count);

    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {


        CountDownLatch countDownLatch = new CountDownLatch(1000);
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            Callable callable = () -> {
                inc();
                return true;
            };
            Future<Boolean> future = es.submit(callable);
            if (future.get()) {
                countDownLatch.countDown();
            }

        }

        countDownLatch.await();
        System.out.println("Counter.count=" + Counter.count);
    }
}

