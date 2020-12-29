package com.bjpowernode.util;


public class ServiceFactory {
    //传递张三对象，取得李四对象
    public static Object getService(Object service) {
        return new TransactionInvocationHandler(service).getProxy();
    }
}
