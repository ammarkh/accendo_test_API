package com.homework.assignment.dto;

import com.homework.assignment.model.TeacherClass;

public class StudentClassDto {
    private long studentId;
    private long classId;
    private String title;
    private boolean submit;

    public StudentClassDto() {
    }

    public StudentClassDto(TeacherClass teacherClass, boolean submit) {
        this.classId = teacherClass.getClassId();
        this.title = teacherClass.getTitle();
        this.submit = submit;
    }

    public long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isSubmit() {
        return submit;
    }

    public void setSubmit(boolean submit) {
        this.submit = submit;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }
}
