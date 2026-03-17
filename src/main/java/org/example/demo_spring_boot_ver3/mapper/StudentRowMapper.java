package org.example.demo_spring_boot_ver3.mapper;
import org.example.demo_spring_boot_ver3.model.Student;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
//        Integer a = resultSet.getInt("id");
//        String b = resultSet.getString("name");

        Student student = new Student();
        student.setId(resultSet.getInt("id"));
        student.setName(resultSet.getString("name"));

        return student;
    }
}
