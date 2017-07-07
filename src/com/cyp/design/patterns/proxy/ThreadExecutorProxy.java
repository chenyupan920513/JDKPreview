package com.cyp.design.patterns.proxy;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/5/8.
 */
public class ThreadExecutorProxy {

    private final static String POOL_NAME = "thread_pool";
    private final static int DEFAULT_CORE_POOL_SIZE = 1;
    private final static int DEFAULT_MAX_POOL_SIZE = 6;
    private final static int KEEP_ALIVE_TIME = 60;
    private final static String ASYNC_THREAD_NAME = "single-async-thread";
    private static ThreadExecutor sExecutor;
    private static boolean sIsInit;
    private static int sCorePoolSize = DEFAULT_CORE_POOL_SIZE;

   /* private static HandlerThread sSingleAsyncThread;

    private static Handler sSingleAsyncHandler;

    private static Handler sMainHandler;

    private static MessageQueue sMsgQueue;

    public static void init() {
        if (sIsInit) {
            return;
        }
        sCorePoolSize = CpuManager.getCpuCoreNums() - 1;
        if (sCorePoolSize < DEFAULT_CORE_POOL_SIZE) {
            sCorePoolSize = DEFAULT_CORE_POOL_SIZE;
        }
        if (sCorePoolSize > DEFAULT_MAX_POOL_SIZE) {
            sCorePoolSize = DEFAULT_MAX_POOL_SIZE;
        }
        sExecutor = new ThreadExecutor();

        sSingleAsyncThread = new HandlerThread(ASYNC_THREAD_NAME);
        sSingleAsyncThread.start();
        sSingleAsyncHandler = new Handler(sSingleAsyncThread.getLooper());

        sMainHandler = new Handler(Looper.getMainLooper());

        sMsgQueue = Looper.myQueue();
        sIsInit = true;
    }

    *//**
     * 提交异步任务到线程池中执行
     *
     * @param task 需要执行的任务
     *//*
    public static void execute(Runnable task) {
        sExecutor.execute(task);
    }


    *//**
     * 取消指定的任务
     *
     * @param task
     *//*
    public static void cancel(final Runnable task) {
        sExecutor.cancel(task);
        sSingleAsyncHandler.removeCallbacks(task);
        sMainHandler.removeCallbacks(task);
    }

    *//**
     * 销毁对象
     *//*
    public static void destroy() {
        sExecutor.destroy();
        sSingleAsyncHandler.removeCallbacksAndMessages(null);
        sMainHandler.removeCallbacksAndMessages(null);
    }

    *//**
     * 提交一个Runable到异步线程队列，该异步线程为单队列
     *
     * @param r
     *//*
    public static void runOnAsyncThread(Runnable r) {
        sSingleAsyncHandler.post(r);
    }

    *//**
     * 提交一个Runable到异步线程队列，该异步线程为单队列
     *
     * @param r
     * @param delay
     *//*
    public static void runOnAsyncThread(Runnable r, long delay) {
        sSingleAsyncHandler.postDelayed(r, delay);
    }

    *//**
     * 提交一个Runable到主线程队列
     *
     * @param r
     *//*
    public static void runOnMainThread(Runnable r) {
        sMainHandler.post(r);
    }

    *//**
     * 提交一个Runable到主线程队列
     *
     * @param r
     * @param delay
     *//*
    public static void runOnMainThread(Runnable r, long delay) {
        sMainHandler.postDelayed(r, delay);
    }

    *//**
     * 提交一个Runnable到主线程空闲时执行
     *
     * @param r
     *//*
    public static void runOnIdleTime(final Runnable r) {
        IdleHandler handler = new IdleHandler() {

            @Override
            public boolean queueIdle() {
                r.run();
                return false;
            }
        };
        sMsgQueue.addIdleHandler(handler);
    }
*/

    private static class ThreadExecutor extends AbstractThreadExecutor {

        private ThreadExecutor() {

        }

        @Override
        protected ThreadPoolManager initThreadPoolManager() {
            ThreadPoolManager manager = ThreadPoolManager.buildInstance(POOL_NAME, sCorePoolSize,
                    DEFAULT_MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS, false,
                    getTaskExecuteListener());
            return manager;
        }
    }
}
