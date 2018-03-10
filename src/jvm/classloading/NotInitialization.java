package jvm.classloading;

/**
 * @Author pierre
 * 18-3-7
 * 通过子类引用父类的静态字段,不会导致子类的初始化
 * 指定参数: -XX:+TraceClassLoading   可以观察到此操作会导致子类的加载
 */
public class NotInitialization {
    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }
}
