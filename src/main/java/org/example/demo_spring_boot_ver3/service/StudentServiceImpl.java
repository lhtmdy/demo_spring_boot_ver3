package org.example.demo_spring_boot_ver3.service;

import org.example.demo_spring_boot_ver3.model.Student;
import org.example.demo_spring_boot_ver3.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentServiceImpl implements  StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public Student getById(Integer studentId) {
        return studentDao.getById(studentId);
    }

    @Override
    public String insert(Student student){
        return studentDao.insert(student);
    }

    @Override
    public String insertList(List<Student> studentList){
        return  studentDao.insertList(studentList);
    }


    @Override
    public String delete(Integer studentId){
        return studentDao.delete(studentId);
    }

    @Override
    public List<Student> select(){
        return studentDao.select();
    }
}
