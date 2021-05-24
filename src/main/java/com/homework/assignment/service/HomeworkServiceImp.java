package com.homework.assignment.service;

import com.homework.assignment.model.HomeWork;
import com.homework.assignment.repository.HomeworkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("HomeworkService")
public class HomeworkServiceImp implements HomeworkService {
    @Autowired
    private HomeworkRepo homeworkRepo;

    @Override
    public HomeWork getById(long homeworkId) {
        return homeworkRepo.findById(homeworkId).get();
    }

    @Override
    public List<HomeWork> getHomeworkByTeacherClassId(long teacherClassId) {
        return homeworkRepo.findAllByTeacherClass(teacherClassId);
    }

    @Override
    public void add(HomeWork homeWork) {
        homeworkRepo.save(homeWork);
    }

    @Override
    public void submitHomework(long homeworkId, long studentId, Date dueDate) {
        this.homeworkRepo.submitHomeworkToStudent(studentId, homeworkId, dueDate);
    }
}
