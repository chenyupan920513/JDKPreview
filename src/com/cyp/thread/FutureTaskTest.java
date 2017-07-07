package com.cyp.thread;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {

    public static void main(String[] args) {

        Callable<Integer> myCallable = new MyCallable();
        FutureTask<Integer> ft = new FutureTask<Integer>(myCallable);

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 30) {
                Thread thread = new Thread(ft);
                thread.start();
            }
        }


        try {
            int sum = ft.get();
            System.out.println("sum = " + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}


class MyCallable implements Callable<Integer> {
    private int i = 0;

    @Override
    public Integer call() {
        int sum = 0;
        for (; i < 100; i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args){

        SimpleDateFormat 格式=new SimpleDateFormat("y年M月d日 E H时m分s秒", Locale.CHINA);
        Calendar 日历=Calendar.getInstance(Locale.CHINA);
        日历.setFirstDayOfWeek(Calendar.MONDAY);
        //当前时间，貌似多余，其实是为了所有可能的系统一致
        //日历.setTimeInMillis(System.currentTimeMillis());
        System.out.println("当前时间:"+格式.format(日历.getTime()));
            日历.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        System.out.println("周一时间:"+格式.format(日历.getTime()));
        日历.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        System.out.println("周日时间:"+格式.format(日历.getTime()));
    }
    
}
