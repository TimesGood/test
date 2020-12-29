package com.bjpowernode.test;

import com.bjpowernode.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Test {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        //输入流
        InputStream inputStream = null;

        {
            try {
                //通过加载MyBatis主配置文件mybatis-config.xml，创建流对象
                inputStream = Resources.getResourceAsStream(resource);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    /*
        SqlSessionFactoryBuilder()：SqlSessionFactory的创建者
        通过该创建者对象调用建造方法，为我们创建一个SqlSessionFactory对象
        sqlSessionFactory对象唯一的作用就是为我们创建SqlSession对象


    */

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //我们未来所有的操作，使用的都是SqlSession对象
        //例如增删改查等
        SqlSession session = sqlSessionFactory.openSession();

        /*
        需求：根据id查询单条数据
        如果取得的是单条数据，我们调用selectOne()方法
        参数1：根据命名空间.sqlId的形式找到我们需要使用的sql语句
        参数2：我们要为sql语句中传递的参数
        */
//        Student s = session.selectOne("test1.getById","A001");
//        System.out.println(s);
//        session.close();


        /*
        插入一条数据
        JDBC默认自动提交事务，而MyBatis默认情况下手动提交事务
        */
//        Student s = new Student();
//        s.setId("A003");
//        s.setName("赵六");
//        s.setAge(25);
//        session.insert("test1.save",s);
//        session.commit();//提交事务
//        session.close();
//

        /*
        更新一条数据
        */
//        Student s = new Student();
//        s.setId("A002");
//        s.setName("赵5");
//        s.setAge(28);
//        session.update("test1.update",s);
//        session.commit();//提交事务
//        session.close();

        /*
        删除一条数据
        */
        session.delete("test1.delete","A001");
        session.commit();//提交事务
        session.close();


    }

}
