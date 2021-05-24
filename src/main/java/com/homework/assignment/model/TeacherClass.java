package com.homework.assignment.model;

import com.homework.assignment.dto.TeacherClassDto;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "teacher_class")
public class TeacherClass {
    @Id
    @Column(name = "class_id", nullable = false)
    @GeneratedValue(generator = "seq_c", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_c", sequenceName = "seq_c", allocationSize = 1, initialValue = 1)
    private long classId;
    @Column(name = "title", nullable = false)
    private String title;

    @ManyToMany(mappedBy = "teacherClass")
    private Set<Student> students = new HashSet<>();

    @OneToMany(mappedBy = "teacherClass")
    private Set<HomeWork> homeWorks = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    public TeacherClass() {
    }

    public TeacherClass(TeacherClassDto teacherClassDto) {
        this.teacher = new Teacher(teacherClassDto.getTeacherDto().getTeacherId());
        this.title = teacherClassDto.getTitle();
    }

    public TeacherClass(long classId) {
        this.classId = classId;
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

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<HomeWork> getHomeWorks() {
        return homeWorks;
    }

    public void setHomeWorks(Set<HomeWork> homeWorks) {
        this.homeWorks = homeWorks;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }


}
