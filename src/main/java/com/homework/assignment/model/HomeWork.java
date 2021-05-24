package com.homework.assignment.model;

import com.homework.assignment.dto.HomeWorkDto;
import org.hibernate.annotations.Formula;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "homework")
public class HomeWork {
    @Id
    @Column(name = "homework_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_homework")
    @SequenceGenerator(name = "seq_homework", sequenceName = "seq_homework", initialValue = 1, allocationSize = 1)
    private long homeWorkId;
    @Column(name = "title", nullable = false)
    @NonNull
    private String title;
    @Column(name = "due_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dueDate;


    @ManyToOne
    @JoinColumn(name = "class_id")
    private TeacherClass teacherClass;

    @OneToMany(mappedBy = "homeWork")
    private Set<StudentHomeWork> studentHomeWorks = new HashSet<>();

    public HomeWork() {
    }

    public HomeWork(HomeWorkDto homeWorkDto) {
        this.title = homeWorkDto.getTitle();
        this.dueDate = homeWorkDto.getDueDate();
        this.teacherClass = new TeacherClass(homeWorkDto.getTeacherClass().getClassId());

    }

    public long getHomeWorkId() {
        return homeWorkId;
    }

    public void setHomeWorkId(long homeWorkId) {
        this.homeWorkId = homeWorkId;
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

    public TeacherClass getTeacherClass() {
        return teacherClass;
    }

    public void setTeacherClass(TeacherClass teacherClass) {
        this.teacherClass = teacherClass;
    }

    public Set<StudentHomeWork> getStudentHomeWorks() {
        return studentHomeWorks;
    }

    public void setStudentHomeWorks(Set<StudentHomeWork> studentHomeWorks) {
        this.studentHomeWorks = studentHomeWorks;
    }


}
