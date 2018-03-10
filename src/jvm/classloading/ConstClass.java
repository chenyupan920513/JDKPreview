package jvm.classloading;

/**
 * @Author pierre
 * 18-3-7
 */
public class ConstClass {

    static {
        System.out.println("ConstClass init !");
    }

    public static final String HELLOWORLD = "hello world !";
}

