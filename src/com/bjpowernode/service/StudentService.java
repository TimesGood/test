package com.bjpowernode.service;

import com.bjpowernode.domain.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    public Student getById(String id);
    public void save(Student s);

    List<Student> getAll();

    List<Student> select1(String name);

    List<Map<String,Object>> select2();

    List<Student> select3();

    List<Student> select4(Student s);

    List<Student> select5(String[] strArr);

    List<Student> select6(String id);

    List<Map<String, Object>> select7();
}
