package com.bjpowernode.service.impl;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import com.bjpowernode.util.SqlSessionUtil;

import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements StudentService {

    //private StudentDao studentDao = new StudentDaoImpl();
    //在结合了MyBatis的动态代理之后，从我们传统的调用dao实现类改为了通过getMapper方法为我们自动创建实现类了
    //相当于SqlSessionUtil.getSession().getMapper(StudentDao.class)就等于new StudentDaoImpl()，省去了创建实现类
    private StudentDao studentDao = SqlSessionUtil.getSession().getMapper(StudentDao.class);
    @Override
    public Student getById(String id) {
        Student s = studentDao.getById(id);
        return s;
    }

    @Override
    public void save(Student s) {
        studentDao.save(s);
    }

    @Override
    public List<Student> getAll() {
        List<Student> sList = studentDao.getAll();
        return sList;
    }

    @Override
    public List<Student> select1(String name) {
        List<Student> sList = studentDao.select1(name);
        return sList;
    }

    @Override
    public List<Map<String,Object>> select2() {
        List<Map<String,Object>> sList = studentDao.select2();
        return sList;
    }

    @Override
    public List<Student> select3() {
        List<Student> sList = studentDao.select3();
        return sList;
    }

    @Override
    public List<Student> select4(Student s) {
        List<Student> sList = studentDao.select4(s);
        return sList;
    }

    @Override
    public List<Student> select5(String[] strArr) {
        List<Student> sList = studentDao.select5(strArr);
        return sList;
    }

    @Override
    public List<Student> select6(String id) {
        List<Student> sList = studentDao.select6(id);
        return sList;
    }

    @Override
    public List<Map<String, Object>> select7() {
        List<Map<String,Object>> mapList = studentDao.select7();
        return mapList;
    }
}
