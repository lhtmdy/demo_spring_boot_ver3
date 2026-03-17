package org.example.demo_spring_boot_ver3.dao;

import org.example.demo_spring_boot_ver3.model.Student;

import java.util.List;


public interface StudentDao {
    Student getById(Integer studentId );

    String insert(Student student);

    String insertList(List<Student>studentList);

    String delete(Integer studentId);

    List<Student> select();
}
