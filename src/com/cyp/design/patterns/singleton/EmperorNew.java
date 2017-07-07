package com.cyp.design.patterns.singleton;

/**
 *
 * @author 阿福(trygf521@126.com)<br>
 *中国的历史上都是一个朝代一个皇帝，有两个皇帝的话，必然要PK一个皇帝出来
 */
public class EmperorNew {
    //定义一个皇帝放在那里，然后给这个皇帝起个名字
    private static final EmperorNew emperorNew = new EmperorNew();;

    private EmperorNew(){
        //世俗和道德的约束你，目的就不让你产生第二个皇帝
    }

    public  synchronized static  EmperorNew getInstance(){

        return emperorNew;
    }

    //皇帝叫什么名字呀
    public static void emperorInfo(){
        System.out.println("我是皇帝某某某...阿福");
    }

}
