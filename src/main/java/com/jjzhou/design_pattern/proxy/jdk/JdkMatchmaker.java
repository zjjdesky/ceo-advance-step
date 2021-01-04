package com.jjzhou.design_pattern.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author jjzhou
 * @date 2021/1/4 5:16 下午
 * @description
 */
public class JdkMatchmaker implements InvocationHandler {

    private Person target;

    public Object getInstance(Person person) {
        this.target = person;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("run before ...");
        Object obj = method.invoke(this.target, args);
        System.out.println("run after ...");
        return obj;
    }
}
