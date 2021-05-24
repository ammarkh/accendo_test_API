package com.homework.assignment.model;

import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "student_homework")
public class StudentHomeWork {
    @EmbeddedId
    private StudentHomeworkId studentHomeworkId;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private Student student;

    @ManyToOne
    @MapsId("homeworkId")
    @JoinColumn(name = "homework_id", referencedColumnName = "homework_id")
    private HomeWork homeWork;
    @Column(name = "due_date", nullable = true)
    private Date dueDate;
    @Column(name = "submit", columnDefinition = "int default 0")
    private boolean submit;

    public StudentHomeworkId getStudentHomeworkId() {
        return studentHomeworkId;
    }

    public void setStudentHomeworkId(StudentHomeworkId studentHomeworkId) {
        this.studentHomeworkId = studentHomeworkId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public HomeWork getHomeWork() {
        return homeWork;
    }

    public void setHomeWork(HomeWork homeWork) {
        this.homeWork = homeWork;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isSubmit() {
        return submit;
    }

    public void setSubmit(boolean submit) {
        this.submit = submit;
    }


}
