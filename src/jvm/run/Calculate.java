package jvm.run;

/**
 * @Author pierre
 * 18-3-9
 * 编译之后执行这条命令  可以查看java 字节码 javap -c -verbose Calculate
 */
public class Calculate {
    public int calculate() {
        int a = 100;
        int b = 200;
        int c = 300;
        return (a + b) * c;
    }
}
