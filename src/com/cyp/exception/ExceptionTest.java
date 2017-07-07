package com.cyp.exception;

/**
 * Created by Administrator on 2017/7/4.
 */
public class ExceptionTest {
    static int counta =0;
    static int countb =0;
    static int countc =0;
    public  static void main(String[] args){
        ExceptionTest t=new ExceptionTest();
        for(int i=0;i<10;i++){

            new Thread(() -> {
                try {
                    Thread.currentThread().sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                t.a();
            }).start();
            new Thread(() -> {
                try {
                    Thread.currentThread().sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                t.b();
            }).start();
            new Thread(() -> {
                try {
                    Thread.currentThread().sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                t.c();
            }).start();
        }

    }

    public void a(){
        counta ++;
        Exception e = new Exception();
        String _methodName =  e.getStackTrace()[1].getMethodName();// 获得调用者的方法名
        String _thisMethodName =  e.getStackTrace()[0].getMethodName();// 获得当前的方法名
        System.out.println(_methodName);
        System.out.println(_thisMethodName);
        System.out.println("counta ==" +counta);
        System.out.println("==========================");
    }

    public void b(){
        countb++;
        Exception e = new Exception();
        String _methodName =  e.getStackTrace()[1].getMethodName();// 获得调用者的方法名
        String _thisMethodName =  e.getStackTrace()[0].getMethodName();// 获得当前的方法名
        System.out.println(_methodName);
        System.out.println(_thisMethodName);
        System.out.println("countb ==" +countb);
        System.out.println("==========================");
    }

    public void c(){
        countc ++;
        Exception ex = new Exception();
        String _methodName =  ex.getStackTrace()[1].getMethodName();// 获得调用者的方法名
        String _thisMethodName =  ex.getStackTrace()[0].getMethodName();// 获得当前的方法名
        System.out.println(_methodName);
        System.out.println(_thisMethodName);
        System.out.println("countc ==" +countc);
        System.out.println("==========================");

    }
}
