package com.homework.assignment.dto;

import com.homework.assignment.model.HomeWork;
import org.hibernate.annotations.Formula;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Basic;
import java.util.Date;

public class HomeWorkDto {
    private long homeworkId;
    private String title;
    private Date dueDate;
    private TeacherClassDto teacherClass;
    private boolean submit;
    private long count;

    public HomeWorkDto() {
    }

    public HomeWorkDto(HomeWork homeWork) {
        this.title = homeWork.getTitle();
        this.dueDate = homeWork.getDueDate();
        this.homeworkId = homeWork.getHomeWorkId();

    }

    public HomeWorkDto(HomeWork homeWork, boolean submit) {
        this.title = homeWork.getTitle();
        this.dueDate = homeWork.getDueDate();
        this.homeworkId = homeWork.getHomeWorkId();
        this.submit = submit;
    }

    public long getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(long homeworkId) {
        this.homeworkId = homeworkId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public TeacherClassDto getTeacherClass() {
        return teacherClass;
    }

    public void setTeacherClass(TeacherClassDto teacherClass) {
        this.teacherClass = teacherClass;
    }

    public boolean isSubmit() {
        return submit;
    }

    public void setSubmit(boolean submit) {
        this.submit = submit;
    }


}
