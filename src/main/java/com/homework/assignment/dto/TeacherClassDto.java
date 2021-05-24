package com.homework.assignment.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.homework.assignment.model.TeacherClass;

import java.util.Set;


public class TeacherClassDto {
    private long classId;
    private String title;
    @JsonProperty("teacher")
    private TeacherDto teacherDto;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<StudentDto> students;

    public TeacherClassDto() {
    }

    public TeacherClassDto(TeacherClass teacherClass) {
        this.classId = teacherClass.getClassId();
        this.title = teacherClass.getTitle();

        teacherDto = new TeacherDto(teacherClass.getTeacher());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TeacherDto getTeacherDto() {
        return teacherDto;
    }

    public void setTeacherDto(TeacherDto teacherDto) {
        this.teacherDto = teacherDto;
    }

    public long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }

    public Set<StudentDto> getStudents() {
        return students;
    }

    public void setStudents(Set<StudentDto> students) {
        this.students = students;
    }
}
