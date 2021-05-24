package com.homework.assignment.service;

import com.homework.assignment.model.Teacher;
import com.homework.assignment.repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service("TeacherService")
public class TeacherServiceImp implements TeacherService {
    @Autowired
    private TeacherRepo teacherRepo;

    @Override
    public Optional<Teacher> findById(Long teacherId) {
        return Optional.empty();
    }

    @Override
    public Teacher checkTeacherCredential(String username, String password) {
        return teacherRepo.checkTeacherCredential(username, password);
    }

    @Override
    public Teacher add(Teacher teacher) {
        Objects.requireNonNull(teacher, "teacher is required");
        teacherRepo.save(teacher);
        return teacher;
    }
}
