package com.cyp.design.patterns.singleton;

/**
 * Created by Administrator on 2017/6/8.
 */
public class Minister {

    public static void main(String[] args) {

        //第一天
        Emperor  emperor1 = Emperor.getInstance();
        //第一天见的皇帝叫什么名字呢？
        emperor1.emperorInfo();

        //第二天
        Emperor  emperor2 = Emperor.getInstance();
        //第二天见的皇帝叫什么名字呢？
        emperor2.emperorInfo();

        //第三天
        Emperor  emperor3 = Emperor.getInstance();
        //第三天见的皇帝叫什么名字呢？
        emperor3.emperorInfo();

        //三天见的皇帝都是同一个人，荣幸吧，呵呵。
    }
}
