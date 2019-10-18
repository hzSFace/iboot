package com.sface.itemplate.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @className JDKDynamicProxy
 * @Desc JDK 动态代理
 * @Author HZ
 * @Date 2019/8/21 21:04
 * @Version 1.0
 */
public class JDKDynamicProxy implements InvocationHandler {

    private Object tragetObj;

    public JDKDynamicProxy(Object tragetObj) {
        this.tragetObj = tragetObj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("-------------------目标对象的方法执行之前打印");
        Object result = method.invoke(tragetObj, args);
        System.out.println("-------------------目标对象的方法执行之后打印");
        return result;
    }
}
