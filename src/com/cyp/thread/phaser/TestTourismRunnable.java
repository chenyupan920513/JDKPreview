package com.cyp.thread.phaser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;

/**
 * Created by Administrator on 2017/4/26.
 */
public class TestTourismRunnable {
    public static void main(String[] args) {
        String name = "明刚红丽黑白";
        Phaser phaser = new Phaser(name.length());
        List<Thread> tourismThread = new ArrayList<>();
        for (char ch : name.toCharArray()){
            tourismThread.add(new Thread(new TourismRunnable(phaser), "小" + ch));
        }
        for (Thread thread : tourismThread){
            thread.start();
        }
    }
}
