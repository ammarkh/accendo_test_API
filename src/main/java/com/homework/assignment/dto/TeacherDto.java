package com.homework.assignment.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.homework.assignment.model.Teacher;

import java.util.Optional;

public class TeacherDto {
    private long teacherId;
    private String username;
    private String fullName;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String password;

    public TeacherDto() {
    }

    public TeacherDto(Teacher teacher) {
        this.fullName = teacher.getFullName();
        this.teacherId = teacher.getTeacherId();
        this.username = teacher.getUserName();
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
