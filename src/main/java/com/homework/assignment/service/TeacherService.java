package com.homework.assignment.service;

import com.homework.assignment.model.Teacher;

import java.util.Optional;

public interface TeacherService {
    Optional<Teacher> findById(Long teacherId);

    Teacher checkTeacherCredential(String username, String password);

    Teacher add(Teacher teacher);

}
