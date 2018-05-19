package com.cyp.thread.block;

public class StaticThreadRun {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> ThreadStatic.staticBlockClass(), "t1");
        Thread t2 = new Thread(() -> ThreadStatic.staticMethod(), "t2");

        t1.start();
        t2.start();
    }

}
