package jvm.classloading;

/**
 * @Author pierre
 * 18-3-10
 * 参数设定:-Xss228K
 */
public class Recursion2 {
    private static int count = 0;


    public static void recursion() {
        System.out.println("count=" + count);
        count++;
        recursion();
    }

    public static void main(String[] args) {
        recursion();
    }
}
