package com.bjpowernode.test;

import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import com.bjpowernode.service.impl.StudentServiceImpl;
import com.bjpowernode.util.ServiceFactory;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test1 {
    public static void main(String[] args) {
        //因为提交事务的方法不在业务层中，我们需要提交事务就不能够直接使用这个
        //比喻张三不走事务提交，而李四走事务提交，所以我们需要使用李四的对象来执行事务，之后我们执行事务的时候都走李四的形态
        //StudentService ss = new StudentServiceImpl();
        //获取代理对象，通过代理对象来执行事务
        StudentService ss = (StudentService) ServiceFactory.getService(new StudentServiceImpl());

   /*     List<Student> sList = ss.getAll();
        for (Student s:sList) {
            System.out.println(s);
        }*/


//        模糊查询
       /* List<Student> sList = ss.select1("赵");
        for (Student s:sList) {
            System.out.println(s);
        }*/

//       当返回类型map类型
       /* List<Map<String,Object>> sList = ss.select2();
        for (Map<String,Object> map:sList) {
            Set<String> set = map.keySet();//取得Map集合中的key值保存到Set集合中
            for (String s:set) {
                System.out.println(map.get(s));//通过key值获取其中的元素
            }
            System.out.println("---------------------------");
        }*/
//        当数据库表字段名称和domain类属性名称不一致时的处理
        /*List<Student> sList = sss.select3();
        for (Student s:sList) {
            System.out.println(s);
        }*/
//        动态sql where结合if标签
  /*      Student s = new Student();
        s.setName("赵5");
        List<Student> sList = ss.select4(s);

        for (Student s1:sList) {
            System.out.println(s1);
        }*/

//        动态sql foreach标签
        /*String[] strArr = {"A001","A002","A003"};
        List<Student> sList = ss.select5(strArr);

        for (Student s1:sList) {
            System.out.println(s1);
        }*/

//        sql片段
       /* List<Student> sList = ss.select6("A001");
        for (Student s:sList) {
            System.out.println(s);
        }*/
//       多表联查，查询学生姓名和班级名称
        List<Map<String,Object>> mapList = ss.select7();
        for (Map<String,Object> map:mapList) {
            Set<String> set = map.keySet();
            for (String s:set) {
                System.out.println(map.get(s));
            }
            System.out.println("--------------------------------------------");

        }


    }
}
