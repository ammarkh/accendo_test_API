package com.homework.assignment.service;

import com.homework.assignment.model.TeacherClass;

import java.util.List;

public interface TeacherClassService {

    TeacherClass getById(long classId);
    List<TeacherClass> getByTeacherId(long teacherId);

    List<TeacherClass> getByStudentId(long studentId);

    Iterable<TeacherClass> getList();

    TeacherClass add(TeacherClass teacherClass);

    void joinToClass(long studentId, long classId);
}
