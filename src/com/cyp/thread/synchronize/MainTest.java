package com.cyp.thread.synchronize;

/**
 * Created by Administrator on 2017/4/26.
 */
public class MainTest {


    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread thread = new MyThread();
            thread.start();
        }
    }
}
