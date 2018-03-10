package jvm.classloading;

/**
 * @Author pierre
 * 18-3-7
 * 运行结果显示: 一条线程在死循环,另一条线程在阻塞等待
 * 同一个类加载器下,一个类型只会被初始化一次
 */
public class DeadLoopClassTest {
    static class DeadLoopClass {
        static {

            if (true) {
                System.out.println(Thread.currentThread() + "init DeadLoopClass");
                while (true) {
                }
            }
        }
    }

    public static void main(String[] args) {
        Runnable script = () -> {
            System.out.println(Thread.currentThread() + " start");
            DeadLoopClass dlc = new DeadLoopClass();
            System.out.println(Thread.currentThread() + " run over ");
        };
        Thread thread1 = new Thread(script);
        Thread thread2 = new Thread(script);
        thread1.start();
        thread2.start();

    }
}
