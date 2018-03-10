package jvm.classloading;

/**
 * @Author pierre
 * 18-3-7
 * 通过数组定义来引用类,不会出发此类的初始化
 * 指定参数: -XX:+TraceClassLoading;
 */
public class NotInitialization2 {
    public static void main(String[] args) {
        SuperClass[] sca = new SuperClass[10];
    }
}
