package com.abcd.SpringHibernatePractice.dao;

import com.abcd.SpringHibernatePractice.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by bhalchandra on 11/2/2016.
 */
@Repository
public class StudentDao {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {

        jdbcTemplate = new JdbcTemplate(dataSource);
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public void printAllStudents() {
        List student = jdbcTemplate.queryForList("select * from STUDENT");
        List<Student> sList = jdbcTemplate.query("select * from STUDENT", getMapper());

        System.out.println(sList.get(0).getStudentName());
        updateBatchRecord();
    }

    public void updateBatchRecord() {

        List<Student> students = new ArrayList<>();
        Student s = new Student();
        s.setStudentName("aaba");
        s.setAddress("mumbai");
        students.add(s);

        SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(students.toArray());

        int[] updatedcount = namedParameterJdbcTemplate.batchUpdate("update Student set NAME = :studentName, ADDRESS = :address where ID = :studId", batch);

        Arrays.asList(updatedcount).forEach(ints -> {
            for (int a : ints
                    )
                System.out.println(a);
        });

    }

    public int registerStudent(Student student) {
        return jdbcTemplate.update("INSERT INTO STUDENT (ID,STUDENTNAME,PERCENTAGE,ADDRESS) VALUES (?,?,?,?)",
                student.getStudId(), student.getStudentName(), student.getPercentage(), student.getAddress());
    }

    public int deRegisterStudent(String id) {
        return jdbcTemplate.update("DELETE FROM STUDENT WHERE ID = ?", id);
    }

    public static RowMapper getMapper() {
        return (resultSet, i) -> {
            Student student = new Student();
            student.setStudId(resultSet.getString("ID"));
            student.setStudentName(resultSet.getString("NAME"));
            student.setAddress(resultSet.getString("ADDRESS"));
            return student;
        };
    }

}
