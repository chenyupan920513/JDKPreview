package com.cyp.block;

public class StaticThreadRun {
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				ThreadStatic.staticBlock();
				
			}},"t1");
		Thread t2 = new Thread(new Runnable(){
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				ThreadStatic.staticMethod();
			}},"t2");

		t1.start();
		t2.start();

	}

}
