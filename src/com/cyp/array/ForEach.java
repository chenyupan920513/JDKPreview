package com.cyp.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/5/9.
 */
public class ForEach {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("1");
        a.add("2");
        for(String tmp: a){
            System.out.println(tmp);
            if("2".equals(tmp))
                a.remove(tmp);

        }

        Iterator<String> it = a.iterator();
        while (it.hasNext()){
            String temp = it.next();
            System.out.println(temp);
            if("1".equals(temp))
                it.remove();
        }

        // 返回得到的本质上是一个数组，并没有实现 List 接口add 的方法
        // 对原数组的操作 也会影响到返回的list
        // 具体翻看源码
        List list = Arrays.asList("123","23456");

    }
}
