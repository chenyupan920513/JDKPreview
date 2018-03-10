package jvm.classloading;

/**
 * @Author pierre
 * 18-3-7
 * 常量在编译阶段,会存入调用类的常量池中,本质上并没有直接引用到定义常量的类
 * 虽然在源码中引用了ConstClass 类中的常量 HELLOWORLD,
 * 但是起始在编译阶段通过常量传播优化,已经将此常量的值'hello world !'存储到了NotInitialization3类的常量池中,
 * 以后NotInitialization3对常量ConstClass.HELLOWORLD的引用实际都被转化为NotInitialization类对自身常量池的引用了
 * 也就是说,实际上,NotInitialization3的Class文件之中并没有ConstClass 类的符号引用入口,这两个类在编译完成之后就不存在任何联系了;
 * <p>
 * 指定参数: -XX:+TraceClassLoading;
 */
public class NotInitialization3 {
    public static void main(String[] args) {
        System.out.println(ConstClass.HELLOWORLD);
    }
}
