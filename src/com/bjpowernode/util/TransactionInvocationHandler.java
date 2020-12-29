package com.bjpowernode.util;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//动态代理,也需要背一下
//代理类的业务方法
//这只是为了业务层的动态代理，为什么要动态代理呢？业务层之所以要使用动态代理，是因为业务层本身就是用来处理业务逻辑的
//事务相关的代码，我们不方便放在业务层处理，所以我们想到使用代理类来帮助业务层处理
public class TransactionInvocationHandler implements InvocationHandler {
    private Object target;//代理对象，比如张三

    public TransactionInvocationHandler(Object target) {
        this.target = target;
    }
    //比如这是李四的表白方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SqlSession session = null;
        Object obj = null;
        try {
            session = SqlSessionUtil.getSession();
            //处理业务逻辑
            //这是张三的表白方法
            obj = method.invoke(target,args);
            //处理业务逻辑完毕之后提交事务
            session.commit();
        }catch (Exception e) {
            session.rollback();//提交回滚
            e.printStackTrace();
        }finally {
            SqlSessionUtil.myClose(session);
        }
        return obj;
    }
    //取得李四对象不能通过new对象来获取李四对象，只能通过该方法获得
    public Object getProxy() {
        //取得代理类对象，相当于取得李四对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
}
