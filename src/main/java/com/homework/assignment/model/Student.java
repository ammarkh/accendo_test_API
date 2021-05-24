package com.homework.assignment.model;

import com.homework.assignment.dto.StudentDto;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "student_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_Seq")
    @SequenceGenerator(name = "Seq_S", sequenceName = "Seq_S", allocationSize = 1, initialValue = 1)
    private long studentId;
    @Column(name = "full_name", nullable = false)
    @NonNull
    private String fullName;
    @Column(name = "username", nullable = false, unique = true)
    @NonNull
    private String userName;
    @Column(name = "password", nullable = false)
    @NonNull
    private String password;

    @OneToMany(mappedBy = "student")
    private Set<StudentHomeWork> studentHomeWorks;


    @ManyToMany
    @JoinTable(
            name = "student_class",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "class_id"))
    private Set<TeacherClass> teacherClass = new HashSet<>();

    @Temporal(TemporalType.DATE)
    @Column(name = "creation_date", nullable = false)
    private Date creationDate;

    public Student() {
    }

    public Student(StudentDto studentDto) {
        System.out.println(studentDto.getFullName() + "\t " + studentDto.getUsername());
        this.userName = studentDto.getUsername();
        this.password = studentDto.getPassword();
        this.fullName = studentDto.getFullName();

    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
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

    public Set<StudentHomeWork> getStudentHomeWorks() {
        return studentHomeWorks;
    }

    public void setStudentHomeWorks(Set<StudentHomeWork> studentHomeWorks) {
        this.studentHomeWorks = studentHomeWorks;
    }

    public Set<TeacherClass> getTeacherClass() {
        return teacherClass;
    }

    public void setTeacherClass(Set<TeacherClass> teacherClass) {
        this.teacherClass = teacherClass;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @PrePersist
    protected void onCreate() {
        this.creationDate = new Date();
    }
}
