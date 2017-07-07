package com.cyp.design.patterns.proxy;


import java.util.Collection;
import java.util.HashMap;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.*;

/**
 * Created by Administrator on 2017/5/8.
 */
public class ThreadPoolManager {
    private static HashMap<String, ThreadPoolManager> sThreadPoolManagerhHashMap = new HashMap<String, ThreadPoolManager>();

    private final static int DEFAULT_COREPOOL_SIZE = 4;
    private final static int DEFAULT_MAXIMUMPOOL_SIZE = 4;
    private final static long DEFAULT_KEEPALIVE_TIME = 0;
    private final static TimeUnit DEFAULT_TIMEUNIT = TimeUnit.SECONDS;
    private static ScheduledExecutorService sScheduledExecutorService = null; // 调度线程池
    private static ScheduledRunnable sScheduledRunnable = null; // 调度Runnable
    private ThreadPoolExecutor mWorkThreadPool = null; // 线程池
    private Queue<Runnable> mWaitTasksQueue = null; // 等待任务队列
    private RejectedExecutionHandler mRejectedExecutionHandler = null; // 任务被拒绝执行的处理器
    private Object mLock = new Object();
    private String mName;

    private ThreadPoolManager() {
        this(DEFAULT_COREPOOL_SIZE, DEFAULT_MAXIMUMPOOL_SIZE, DEFAULT_KEEPALIVE_TIME,
                DEFAULT_TIMEUNIT, false, null);
    }

    private ThreadPoolManager(int corePoolSize, int maximumPoolSize, long keepAliveTime,
                              TimeUnit unit, boolean isPriority, final ITaskExecuteListener listener) {
        mWaitTasksQueue = new ConcurrentLinkedQueue<Runnable>();
        if (sScheduledRunnable == null) {
            sScheduledRunnable = new ScheduledRunnable();
            sScheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
            sScheduledExecutorService.scheduleAtFixedRate(sScheduledRunnable, 0, 1500,
                    TimeUnit.MILLISECONDS);
        }
        initRejectedExecutionHandler();
        BlockingQueue<Runnable> queue = isPriority
                ? new PriorityBlockingQueue<Runnable>(16)
                : new LinkedBlockingQueue<Runnable>(16);
        if (listener == null) {
            mWorkThreadPool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime,
                    unit, queue, mRejectedExecutionHandler);
        } else {
            mWorkThreadPool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime,
                    unit, queue, mRejectedExecutionHandler) {
                @Override
                protected void beforeExecute(Thread t, Runnable r) {
                    listener.beforeExecute(t, r);
                }

                @Override
                protected void afterExecute(Runnable r, Throwable t) {
                    listener.afterExecute(r, t);
                }
            };
        }
    }

    public static ThreadPoolManager getInstance(String threadPoolManagerName) {
        ThreadPoolManager threadPoolManager = null;
        if (threadPoolManagerName != null && !"".equals(threadPoolManagerName.trim())) {
            synchronized (sThreadPoolManagerhHashMap) {
                threadPoolManager = sThreadPoolManagerhHashMap.get(threadPoolManagerName);
                if (null == threadPoolManager) {
                    threadPoolManager = new ThreadPoolManager();
                    threadPoolManager.mName = threadPoolManagerName;
                    sThreadPoolManagerhHashMap.put(threadPoolManagerName, threadPoolManager);
                }
            }
        }
        return threadPoolManager;
    }

    public static ThreadPoolManager buildInstance(String threadPoolManagerName,
                                                  int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
                                                  boolean isPriority, ITaskExecuteListener listener) {
        if (threadPoolManagerName == null || "".equals(threadPoolManagerName.trim())
                || corePoolSize < 0 || maximumPoolSize <= 0 || maximumPoolSize < corePoolSize
                || keepAliveTime < 0) {
            return null;
        } else {
            ThreadPoolManager threadPoolManager = new ThreadPoolManager(corePoolSize,
                    maximumPoolSize, keepAliveTime, unit, isPriority, listener);
            threadPoolManager.mName = threadPoolManagerName;
            synchronized (sThreadPoolManagerhHashMap) {
                sThreadPoolManagerhHashMap.put(threadPoolManagerName, threadPoolManager);
            }
            return threadPoolManager;
        }
    }

    /**
     * 初始化调度Runable
     */
    private static class ScheduledRunnable implements Runnable {
        @Override
        public void run() {
            synchronized (sThreadPoolManagerhHashMap) {
                Collection<ThreadPoolManager> values = sThreadPoolManagerhHashMap.values();
                for (ThreadPoolManager manager : values) {
                    manager.executeWaitTask();
                }
            }
        }
    }

    private void executeWaitTask() {
        synchronized (mLock) {
            if (hasMoreWaitTask()) {
                Runnable runnable = mWaitTasksQueue.poll();
                if (runnable != null) {
                    execute(runnable);
                }
            }
        }
    }

    /**
     * 初始化任务被拒绝执行的处理器的方法
     */
    private void initRejectedExecutionHandler() {
        mRejectedExecutionHandler = (r, executor) -> {
            // 把被拒绝的任务重新放入到等待队列中
            synchronized (mLock) {
                mWaitTasksQueue.offer(r);
            }
        };
    }

    /**
     * 是否还有等待任务的方法
     *
     * @return
     */
    public boolean hasMoreWaitTask() {
        boolean result = false;
        if (!mWaitTasksQueue.isEmpty()) {
            result = true;
        }
        return result;
    }

    /**
     * 执行任务的方法
     *
     * @param task
     */
    public void execute(Runnable task) {
        if (task != null) {
            mWorkThreadPool.execute(task);
        }
    }

    /**
     * 取消任务
     *
     * @param task
     */
    public void cancel(Runnable task) {
        if (task != null) {
            synchronized (mLock) {
                if (mWaitTasksQueue.contains(task)) {
                    mWaitTasksQueue.remove(task);
                }
            }
            mWorkThreadPool.remove(task);
        }
    }

    public void removeAllTask() {
        // 如果取task过程中task队列数量改变了会抛异常
        try {
            if (!mWorkThreadPool.isShutdown()) {
                BlockingQueue<Runnable> tasks = mWorkThreadPool.getQueue();
                for (Runnable task : tasks) {
                    mWorkThreadPool.remove(task);
                }
            }
        } catch (Throwable e) {
            System.out.println("ThreadPoolManager" + "removeAllTask " + e.getMessage());
        }
    }

    public boolean isShutdown() {
        return mWorkThreadPool.isShutdown();
    }

    /**
     * 清理方法
     */
    private void cleanUp() {
        if (!mWorkThreadPool.isShutdown()) {
            try {
                mWorkThreadPool.shutdownNow();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        mRejectedExecutionHandler = null;
        synchronized (mLock) {
            mWaitTasksQueue.clear();
        }
    }


    /**
     * 销毁全部ThreadPoolManager
     */
    public static void destroyAll() {
        synchronized (sThreadPoolManagerhHashMap) {
            Set<String> keySet = sThreadPoolManagerhHashMap.keySet();
            if (keySet != null && keySet.size() > 0) {
                ThreadPoolManager threadPoolManager = null;
                for (String key : keySet) {
                    threadPoolManager = sThreadPoolManagerhHashMap.get(key);
                    if (threadPoolManager != null) {
                        threadPoolManager.cleanUp();
                    }
                }
            }
            sThreadPoolManagerhHashMap.clear();
        }
        if (sScheduledExecutorService != null) {
            if (!sScheduledExecutorService.isShutdown()) {
                try {
                    sScheduledExecutorService.shutdownNow();
                } catch (Exception e) {
                    // do nothing
                }
            }
            sScheduledExecutorService = null;
        }
        if (sScheduledRunnable != null) {
            sScheduledRunnable = null;
        }
    }

    /**
     * 销毁某个ThreadPoolManager
     * @param threadPoolManagerName
     */
    public static void destroy(String threadPoolManagerName) {
        synchronized (sThreadPoolManagerhHashMap) {
            ThreadPoolManager threadPoolManager = sThreadPoolManagerhHashMap
                    .get(threadPoolManagerName);
            if (threadPoolManager != null) {
                threadPoolManager.cleanUp();
            }
        }
    }

    /**
     *
     */
    public static interface ITaskExecuteListener {
        public void beforeExecute(Thread thread, Runnable task);
        public void afterExecute(Runnable task, Throwable throwable);
    }
}
