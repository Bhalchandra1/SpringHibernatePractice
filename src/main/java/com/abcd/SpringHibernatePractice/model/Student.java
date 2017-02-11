package com.abcd.SpringHibernatePractice.model;

import java.util.UUID;

/**
 * Created by bhalchandra on 11/1/2016.
 */
public class Student {
    private String studId = UUID.randomUUID().toString();
    private String studentName;
    private String address;

    public String getStudId() {
        return studId;
    }

    public void setStudId(String studId) {
        this.studId = studId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studId=" + studId +
                ", studentName='" + studentName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
