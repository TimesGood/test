package com.bjpowernode.util;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//这个工具类背一下
public class SqlSessionUtil {
    private SqlSessionUtil(){}//私有化构造方法，使其不能创建对象


    private static SqlSessionFactory sqlSessionFactory;

    //静态代码块，只执行一次
    static {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    //用ThreadLocal的作用是储存已经创建好的SqlSession，这样能够统一使用一个事务，如果不用这个，
    //当我们需要使用SqlSession的时候每次都需要创建一个新的SqlSession，造成混淆
    private static ThreadLocal<SqlSession> t = new ThreadLocal<>();
    //取得SqlSession对象
    public static SqlSession getSession() {
        SqlSession session = t.get();//获取已储存的SqlSession
        if(session==null) {//如果没有，则创建并储存
            session = sqlSessionFactory.openSession();
            t.set(session);//储存
        }
        return session;

    }
    //关闭SqlSession对象
    public static void myClose(SqlSession session) {
        if(session!=null) {
            session.close();
            t.remove();//这句必须加，容易忘
        }
    }
}
