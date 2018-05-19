package com.cyp.thread.block;

public class StaticThreadRun2 {
    public static void main(String[] args) {
        Thread t3 = new Thread(() -> {
            ThreadStatic ts1 = new ThreadStatic();
            ThreadStatic ts2 = new ThreadStatic();
            ts1.blockInstance();
//            ts2.blockClass();
        }, "t3");
        Thread t4 = new Thread(() -> {
            ThreadStatic ts1 = new ThreadStatic();
            ThreadStatic ts2 = new ThreadStatic();
//            ts2.blockInstance();
            ts1.blockClass();
        }, "t4");
        t3.start();
        t4.start();
    }

}
