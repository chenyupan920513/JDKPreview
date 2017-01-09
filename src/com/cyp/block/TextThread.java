package com.cyp.block;

public class TextThread {

	public static void main(String[] args) {
		TxtThread tt = new TxtThread();
		TxtThread tt2 = new TxtThread();
		new Thread(tt,"�߳�1").start();
		new Thread(tt,"�߳�2").start();
		new Thread(tt,"�߳�3").start();
		new Thread(tt,"�߳�4").start();
		new Thread(tt2,"�߳�t1").start();
		new Thread(tt2,"�߳�t2").start();
		new Thread(tt2,"�߳�t3").start();
		new Thread(tt2,"�߳�t4").start();
	}
}

class TxtThread implements Runnable {
	int num = 100;
	String str = new String();

	public void run() {
		synchronized (str) {
			while (num > 0) {

				try {
					Thread.sleep(1);
				} catch (Exception e) {
					e.getMessage();
				}
				System.out.println(Thread.currentThread().getName()
						+ "---->>>>   " + num--);
			}
			System.out.println(Thread.currentThread().getName());
		}
	}
}
