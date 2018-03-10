package jvm.classloading;

/**
 * @Author pierre
 * 18-3-7
 */
public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init!");
    }
}

