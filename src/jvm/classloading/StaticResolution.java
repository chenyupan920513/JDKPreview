package jvm.classloading;

/**
 * @Author pierre
 * 18-3-7
 * javap -verbose StaticResolution
 */
public class StaticResolution {
    public static void sayHello() {
        System.out.println("hello world");
    }

    public static void main(String[] args) {
        StaticResolution.sayHello();
    }
}
