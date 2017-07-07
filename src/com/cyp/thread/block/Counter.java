package com.cyp.thread.block;


public class Counter {

	public volatile static int count = 0;

	public  static void inc() {
		count++;
        System.out.println(count);
    }

	public static void main(String[] args) {

	 
	        for (int i = 0; i < 1000; i++) {
	            new Thread(new Runnable() {
	                @Override
	                public void run() {
	                    Counter.inc();
	                }
	            }).start();
	        }

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	        System.out.println("Counter.count=" + Counter.count);
	    }
}

