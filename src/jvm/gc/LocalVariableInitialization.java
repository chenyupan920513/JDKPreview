package jvm.gc;

/**
 * @Author pierre
 * 18-3-7
 */
public class LocalVariableInitialization {
    static int b;

    public static void main(String[] args) {
        int a;
//        System.out.println(a);   //编译不能通过 类变量会在类初始化的时候赋初值  ,但是局部变量不会
        System.out.println(b);
    }
}
