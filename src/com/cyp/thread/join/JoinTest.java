package com.cyp.thread.join;

/**
 * Created by Administrator on 2017/5/27.
 */
public class JoinTest implements  Runnable{

    public static void main(String[] sure) throws InterruptedException {
        Thread t = new Thread(new JoinTest());
        long start = System.currentTimeMillis();
        t.start();
        t.join();//等待线程t 1000毫秒
        System.out.println(System.currentTimeMillis()-start);//打印出时间间隔
        System.out.println("Main finished");//打印主线程结束
    }

    @Override
    public void run() {
//        synchronized (Thread.currentThread()) {
            for (int i = 1; i <= 5; i++) {
                try {
                    Thread.currentThread().join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("睡眠" + i);
            }
            System.out.println("TestJoin finished");//t线程结束
//        }
    }
}
