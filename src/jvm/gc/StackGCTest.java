package jvm.gc;

/**
 * @Author pierre
 * 18-3-7
 * VM 参数设定  -verbose:gc
 */
public class StackGCTest {
    public static void main(String[] args) {
        {
            byte[] placeHolder = new byte[64 * 1024 * 1024];
            placeHolder = null;
        }
//        int i = 1; // 加上这句之后 64M空间才会被回收  原因是: i 会重用placeHolder 的在局部变量表中的位置
// 导致placeHolder 指代的64M空间不可达   这里也可以通过  placeHolder = null ; 使相应的空间被回收
        System.gc();
    }
}
