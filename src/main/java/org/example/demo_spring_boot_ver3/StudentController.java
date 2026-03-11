package org.example.demo_spring_boot_ver3;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class StudentController {

    @Autowired
    private NamedParameterJdbcTemplate  namedParameterJdbcTemplate;

    @PostMapping("/insertStudents")
    public String insert (@RequestBody Student student){
        String sql = "INSERT INTO student(id,name) VALUE(:studentId,:studentName)";
        Map<String, Object> map = new HashMap<>();

        map.put("studentId",student.getId());
        map.put("studentName",student.getName());

        namedParameterJdbcTemplate.update(sql,map);
        return "執行INSERT SQL";

    }

    @DeleteMapping("/deleteStudent/{studentId}")
    public String delete (@PathVariable Integer studentId){
        String sql = "Delete FROM student WHERE id = :studentId";
        Map<String, Object> map = new HashMap<>();

        map.put("studentId",studentId);
        namedParameterJdbcTemplate.update(sql,map);
        return "執行delete sql";
    }
}
