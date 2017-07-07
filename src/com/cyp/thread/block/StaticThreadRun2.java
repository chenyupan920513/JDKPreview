package com.cyp.thread.block;

public class StaticThreadRun2 {
	public static void main(String[] args) {
		Thread t3 = new Thread(new Runnable(){
			
			@Override
			public void run() {
				ThreadStatic ts1 = new ThreadStatic();
				ThreadStatic ts2 = new ThreadStatic();
				ts1.staticBlock2();
				ts2.staticBlock3();
			}},"t3");
		Thread t4 = new Thread(new Runnable(){
			
			@Override
			public void run() {
				ThreadStatic ts1 = new ThreadStatic();
				ThreadStatic ts2 = new ThreadStatic();
				ts1.staticBlock2();
				ts2.staticBlock3();
			}},"t4");
		t3.start();
		t4.start();
	}

}
