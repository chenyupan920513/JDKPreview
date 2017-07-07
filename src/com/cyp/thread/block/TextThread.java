package com.cyp.thread.block;

public class TextThread {

	public static void main(String[] args) {
		TxtThread tt = new TxtThread();
		TxtThread tt2 = new TxtThread();
		new Thread(tt,"线程1").start();
		new Thread(tt,"线程2").start();
		new Thread(tt,"线程3").start();
		new Thread(tt,"线程4").start();
		new Thread(tt2,"线程t1").start();
		new Thread(tt2,"线程t2").start();
		new Thread(tt2,"线程t3").start();
		new Thread(tt2,"线程t4").start();
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
