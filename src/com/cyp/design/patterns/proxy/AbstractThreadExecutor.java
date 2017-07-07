package com.cyp.design.patterns.proxy;

/**
 * Created by Administrator on 2017/5/8.
 */
public abstract class AbstractThreadExecutor {

    protected ThreadPoolManager mManager;

    private byte[] mLock = new byte[0];

    protected abstract ThreadPoolManager initThreadPoolManager();

    protected ThreadPoolManager.ITaskExecuteListener getTaskExecuteListener() {
        return new ThreadPoolManager.ITaskExecuteListener() {

            @Override
            public void beforeExecute(Thread thread, Runnable task) {

            }

            @Override
            public void afterExecute(Runnable task, Throwable throwable) {

            }

        };
    }
    /**
     * 执行一个异步任务
     * @param task 需要执行的任务
     */
    public void execute(Runnable task) {
        if (mManager == null) {
            synchronized (mLock) {
                if (mManager == null) {
                    mManager = initThreadPoolManager();
                }
            }
        }
        mManager.execute(task);
    }

    /**
     * 取消指定的任务
     * @param task
     */
    public void cancel(final Runnable task) {
        if (mManager != null) {
            mManager.cancel(task);
        }
    }

    /**
     * 销毁对象
     */
    public void destroy() {
        if (mManager != null) {
            ThreadPoolManager.destroy(mManager.getClass().getName());
            mManager = null;
        }
    }

}
