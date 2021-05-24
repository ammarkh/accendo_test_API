package com.homework.assignment.service;

import com.homework.assignment.model.Student;


public interface StudentService {
    Student findById(long studentId);

    Student findByStudentCredential(String userName, String password);

    Iterable<Student> findAll();

    public Student add(Student student);
}
