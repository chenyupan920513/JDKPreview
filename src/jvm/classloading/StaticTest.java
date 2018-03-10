package jvm.classloading;

/**
 * @Author pierre
 * 18-3-7
 * 静态语句块只能访问到定义在静态语句快之前的变量,定义在它之后的变量,在静态语句块之后的变量,在前面的静态语句块可以赋值,但是不能访问,
 */
public class StaticTest {
    static {
        i = 0;
        //System.out.println(i); //illegal forward reference
    }

    static int i = 1;

}

