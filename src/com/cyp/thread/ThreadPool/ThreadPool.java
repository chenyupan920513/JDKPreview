package com.cyp.thread.ThreadPool;


import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/5/11.
 */
public class ThreadPool {
	public static void main(String[] args) {
		ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);
		//每隔一段时间就触发异常
		exec.scheduleAtFixedRate(() -> {
			System.out.println("================");
		}, 1000, 5000, TimeUnit.MILLISECONDS);
		//每隔一段时间打印系统时间，证明两者是互不影响的
		exec.scheduleAtFixedRate(() -> System.out.println(System.nanoTime()), 1000, 2000, TimeUnit.MILLISECONDS);
		exec.execute(() -> System.out.println(123));


	}
}
