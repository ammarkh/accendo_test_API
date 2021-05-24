package com.homework.assignment.repository;

import com.homework.assignment.model.Teacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TeacherRepo extends CrudRepository<Teacher, Long> {

    @Query("select t from Teacher t where t.userName = (:username) and t.password =(:password)")
    public Teacher checkTeacherCredential(String username, String password);
}
