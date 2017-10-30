package ru.edhunter.dz4.dynamic_proxy_test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Logger implements InvocationHandler{
    private Object object;

    public Logger(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("logging:" + method.getName());
        return method.invoke(object, args);
    }
}
