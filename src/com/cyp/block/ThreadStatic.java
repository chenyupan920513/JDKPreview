package com.cyp.block;

public class ThreadStatic{
	public synchronized static void  staticMethod(){
		int i=10;
		while(i>0){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println(Thread.currentThread().getName()+"== method "+i--);
		
		}
	}
	
	public static void staticBlock(){
		synchronized (ThreadStatic.class) {
			int i=10;
			while(i>0){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			System.out.println(Thread.currentThread().getName()+"== Block "+i--);
			
			}
		}
		
	}
	public  void staticBlock2(){
		synchronized (this) {
			int i=10;
			while(i>0){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"== Block "+i--);
				
			}
		}
		
	}
	public  void staticBlock3(){
		synchronized (ThreadStatic.class) {
			int i=10;
			while(i>0){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"== Block "+i--);
				
			}
		}
		
	}

}
