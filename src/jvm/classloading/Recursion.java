package jvm.classloading;

/**
 * @Author pierre
 * 18-3-10
 * 参数设定:-Xss228K
 */
public class Recursion {
    private static int count = 0;

    public static void recursion(int a, int b, int c) {
        long l1 = 12;
        short sl = 1;
        byte b1 = 1;
        String s = "1";
        System.out.println("count=" + count);
        count++;
        recursion(1, 2, 3);
    }


    public static void main(String[] args) {
        recursion(1, 2, 3);
    }
}
