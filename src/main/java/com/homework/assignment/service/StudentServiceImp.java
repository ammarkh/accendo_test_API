package com.homework.assignment.service;

import com.homework.assignment.model.Student;
import com.homework.assignment.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service("StudentService")
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Student findById(long studentId) {
        return studentRepo.findById(studentId).get();
    }

    @Override
    public Student findByStudentCredential(String username, String password) {
        return studentRepo.checkFromUserNameAndPassword(username, password);
    }

    @Override
    public Iterable<Student> findAll() {
        return studentRepo.findAll();
    }

    @Override
    public Student add(Student student) {
        Objects.requireNonNull(student, "student should not be null");
        studentRepo.save(student);
        return student;
    }


}
