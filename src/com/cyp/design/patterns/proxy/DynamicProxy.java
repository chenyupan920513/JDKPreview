package com.cyp.design.patterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/6/8.
 */
public class DynamicProxy implements InvocationHandler{
    private final Object mTarget;//被代理对象的引用

    public DynamicProxy(Object target) {
        mTarget = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //调用被代理对象的方法

        return method.invoke(mTarget,args);
    }
}
