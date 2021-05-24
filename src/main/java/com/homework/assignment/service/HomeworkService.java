package com.homework.assignment.service;

import com.homework.assignment.model.HomeWork;

import java.util.Date;
import java.util.List;

public interface HomeworkService {

    HomeWork getById(long homeworkId);

    List<HomeWork> getHomeworkByTeacherClassId(long teacherClassId);

    void add(HomeWork homeWork);

    void submitHomework(long homeworkId, long studentId, Date dueDate);
}
