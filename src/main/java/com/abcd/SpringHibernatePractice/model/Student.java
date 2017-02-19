package com.abcd.SpringHibernatePractice.model;

import java.util.UUID;

/**
 * MOdel Class for Student
 */

public class Student {
    private String studId = UUID.randomUUID().toString();
    private String studentName;
    private String percentage;
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

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studId=" + studId +
                ", studentName='" + studentName + '\'' +
                ", percentage='" + percentage + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
