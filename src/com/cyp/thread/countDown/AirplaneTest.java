package com.cyp.thread.countDown;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/4/26.
 */
public class AirplaneTest {


    public static void main(String[] args) {
        String visitor = "明刚红丽黑白";
        String kongjie = "美惠花";

        Airplane airplane = new Airplane(visitor.length());
        Set<Thread> threads = new HashSet<>();
        for(int i = 0; i < kongjie.length(); i++){
            threads.add(new Thread(() ->{
                airplane.doWork();
            }, "小" + kongjie.charAt(i) + "空姐"));
        }
        for(int j = 0; j < visitor.length();j++){
            threads.add(new Thread(() ->{
                airplane.getOffPlane();
            }, "小" + visitor.charAt(j)));
        }


        for(Thread thread : threads){
            thread.start();
        }
    }
}
