package com.abcd.SpringHibernatePractice.service;

import com.abcd.SpringHibernatePractice.dao.StudentDao;
import com.abcd.SpringHibernatePractice.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for Student
 */

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public String registerStudent(Student student) {
        String response = "Registration is successfully completed for %s";
        // TODO:Validation may need to add
        if (studentDao.registerStudent(student) > 0)
            return String.format(response, student.getStudentName());
        return "Error in registration";
    }

    public String deRegisterStudent(String id) {
        String response = "De-Registration is successfully completed";
        studentDao.deRegisterStudent(id);
        return response;
    }

    public void updateStudent() {

    }
}
