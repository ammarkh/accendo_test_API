package com.homework.assignment.repository;

import com.homework.assignment.model.TeacherClass;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TeacherClassRepo extends CrudRepository<TeacherClass, Long> {

    @Query("Select tc from TeacherClass tc where  tc.teacher.teacherId = (:teacherId)")
    List<TeacherClass> findByTeacherId(long teacherId);

    @Modifying
    @Query(value = "insert into student_class(student_id,class_id ) values (:studentId, :classId) ", nativeQuery = true)
    @Transactional
    void insertStudentClass(long studentId, long classId);

}
