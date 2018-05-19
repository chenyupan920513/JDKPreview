package com.cyp.thread.block;

public class ThreadStatic {
    public synchronized static void staticMethod() {
        int i = 10;
        while (i > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "== method " + i--);

        }
    }

    public static void staticBlockClass() {
        synchronized (ThreadStatic.class) {
            int i = 10;
            while (i > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "== Block " + i--);

            }
        }

    }

    public void blockInstance() {
        synchronized (this) {
            int i = 10;
            while (i > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "== Block instance " + i--);

            }
        }

    }

    public void blockClass() {
        synchronized (ThreadStatic.class) {
            int i = 10;
            while (i > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "== Block class " + i--);

            }
        }

    }

}
