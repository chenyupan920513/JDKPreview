package com.cyp.design.patterns.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2017/4/24.
 */
public class Client {

    /*public static void main(String[] args) {

        IShop xiaoMing = new XiaoMing();
        //创建代购者并将xiaoMing作为构造函数传
        IShop proxyBuyer = new ProxyBuyer(xiaoMing);
        proxyBuyer.buy();
    }*/

    public static void main(String[] args) {
        //构造被代理类小明
        IShop xiaoMing = new XiaoMing();
        //构造一个动态代理
        DynamicProxy dynamicProxy = new DynamicProxy(xiaoMing);
        //获取被代理类小明的classLoader
        ClassLoader classLoader = xiaoMing.getClass().getClassLoader();
        //动态构建代购的人
        IShop proxyBuyer = (IShop) Proxy.newProxyInstance(classLoader,new Class[]{IShop.class},dynamicProxy);
        //进行代购
        proxyBuyer.buy();
    }
}
