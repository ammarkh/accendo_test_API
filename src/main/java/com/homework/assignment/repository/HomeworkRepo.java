package com.homework.assignment.repository;

import com.homework.assignment.model.HomeWork;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface HomeworkRepo extends CrudRepository<HomeWork, Long> {
    @Query("select h from HomeWork h where h.teacherClass.classId=(:classId)")
    List<HomeWork> findAllByTeacherClass(long classId);

    @Modifying
    @Query(value = "insert into student_homework (student_id, homework_id, due_date) values (:studentId, :homeworkId, :dueDate)", nativeQuery = true)
    @Transactional
    void submitHomeworkToStudent(long studentId, long homeworkId, Date dueDate);

}
