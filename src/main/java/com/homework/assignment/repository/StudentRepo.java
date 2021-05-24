package com.homework.assignment.repository;

import com.homework.assignment.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface StudentRepo extends CrudRepository<Student, Long> {

    @Query("Select s  from Student s where s.userName = (:username) and s.password = (:password)")
    Student checkFromUserNameAndPassword(String username, String password);
}
