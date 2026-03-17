package org.example.demo_spring_boot_ver3.dao;

import org.example.demo_spring_boot_ver3.model.Student;
import org.example.demo_spring_boot_ver3.mapper.StudentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StudentDaoImpl implements  StudentDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Student getById(Integer studentId) {
        String sql = "SELECT id, name FROM student WHERE id = :studentId";

        Map<String, Object> map = new HashMap<>();
        map.put("studentId",studentId);
        List<Student> list = namedParameterJdbcTemplate.query(sql,map, new StudentRowMapper());

        if(list.size()>0){
            return list.get(0);
        }else{
            return  null;
        }
    }

    @Override
    public String insert(Student student){
        String sql = "INSERT INTO student(name) VALUE(:studentName)";
        Map<String, Object> map = new HashMap<>();

        map.put("studentName",student.getName());

        KeyHolder keyholder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql,new MapSqlParameterSource(map),keyholder);
        int id = keyholder.getKey().intValue();

        System.out.println("mysql 自動生成的 id為:"+id);
        return "執行INSERT SQL";
    }

    @Override
    public String insertList(List<Student> studentList){
        String sql = "INSERT INTO student(name) VALUE(:studentName)";

        MapSqlParameterSource[] parameterSources = new MapSqlParameterSource[studentList.size()];

        for(int i=0; i<studentList.size(); i++){
            Student student = studentList.get(i);

            parameterSources[i] = new MapSqlParameterSource();
            parameterSources[i].addValue("studentName", student.getName());
        }

        namedParameterJdbcTemplate.batchUpdate(sql,parameterSources);

        return "執行batch sql";
    }

    @Override
    public String delete(Integer studentId){
        String sql = "Delete FROM student WHERE id = :studentId";
        Map<String, Object> map = new HashMap<>();

        map.put("studentId",studentId);
        namedParameterJdbcTemplate.update(sql,map);
        return "執行delete sql";
    }

    @Override
    public List<Student> select(){
        String sql = "SELECT id, name FROM student";

        Map<String, Object> map = new HashMap<>();
        List <Student> list = namedParameterJdbcTemplate.query(sql,map, new StudentRowMapper());

        return list;
    }
}
