package jvm.classloading;

/**
 * @Author pierre 18-3-7
 */
public class SuperClass {

    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 123;

}
