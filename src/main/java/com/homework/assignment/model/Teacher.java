package com.homework.assignment.model;

import com.homework.assignment.dto.TeacherDto;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_t")
    @SequenceGenerator(name = "seq_t", sequenceName = "seq_t", initialValue = 1, allocationSize = 1)
    @Column(name = "teacher_id")
    private long teacherId;
    @Column(name = "full_name", nullable = false)
    @NonNull
    private String fullName;
    @Column(name = "username", nullable = false)
    @NonNull
    private String userName;
    @Column(name = "password", nullable = false)
    @NonNull
    private String password;

    @Temporal(TemporalType.DATE)
    @Column(name = "creation_date", nullable = false)
    private Date creationDate;

    public Teacher() {
    }

    public Teacher(long id) {
        this.teacherId = id;
    }

    public Teacher(TeacherDto teacherDto) {
        this.fullName = teacherDto.getFullName();
        this.userName = teacherDto.getUsername();
        this.password = teacherDto.getPassword();
    }

    @OneToMany(mappedBy = "teacher")
    private Set<TeacherClass> teacherClasses = new HashSet<>();

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    @NonNull
    public String getFullName() {
        return fullName;
    }

    public void setFullName(@NonNull String fullName) {
        this.fullName = fullName;
    }

    @NonNull
    public String getUserName() {
        return userName;
    }

    public void setUserName(@NonNull String userName) {
        this.userName = userName;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    public Set<TeacherClass> getClasses() {
        return teacherClasses;
    }

    public void setClasses(Set<TeacherClass> teacherClasses) {
        this.teacherClasses = teacherClasses;
    }

    @PrePersist
    protected void onCreate() {
        this.creationDate = new Date();
    }
}
