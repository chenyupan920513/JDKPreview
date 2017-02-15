package com.cyp.Enum;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class ComparableEnum{
    public static void main(String args[]){
        Set<Color> t = new TreeSet<Color>() ;    // 设置类型
        t.add(Color.GREEN) ;    // 加入绿色
        t.add(Color.RED) ;        // 加入红色
        t.add(Color.BLUE) ;        // 加入蓝色
        t.add(Color.GREEN);
        Iterator<Color> iter = t.iterator() ;
        while(iter.hasNext()){
            System.out.print(iter.next() + "、") ;
        }
    }
};