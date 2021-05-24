package com.homework.assignment.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.homework.assignment.model.Student;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentDto {
    private long studentId;
    @JsonProperty(value = "fullName")
    private String fullName;
    private String username;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String password;


    public StudentDto() {
    }

    public StudentDto(Student student) {
        this.fullName = student.getFullName();
        this.username = student.getUserName();
        this.studentId = student.getStudentId();
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
