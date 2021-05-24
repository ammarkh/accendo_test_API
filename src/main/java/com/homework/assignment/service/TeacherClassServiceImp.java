package com.homework.assignment.service;

import com.homework.assignment.model.TeacherClass;
import com.homework.assignment.repository.TeacherClassRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("TeacherClassService")
public class TeacherClassServiceImp implements TeacherClassService {
    @Autowired
    private TeacherClassRepo teacherClassRepo;

    @Override
    public TeacherClass getById(long classId) {
        return teacherClassRepo.findById(classId).get();
    }

    @Override
    public List<TeacherClass> getByTeacherId(long teacherId) {

        return teacherClassRepo.findByTeacherId(teacherId);
    }

    @Override
    public List<TeacherClass> getByStudentId(long studentId) {
        return null;
    }

    @Override
    public Iterable<TeacherClass> getList() {
        return teacherClassRepo.findAll();
    }

    @Override
    public TeacherClass add(TeacherClass teacherClass) {
        teacherClassRepo.save(teacherClass);
        return this.getById(teacherClass.getClassId());
    }

    @Override
    public void joinToClass(long studentId, long classId) {
        this.teacherClassRepo.insertStudentClass(studentId, classId);
    }
}
