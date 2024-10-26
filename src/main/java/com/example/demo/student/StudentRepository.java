package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository //indicates that the interface is a Spring Data Repository.
// It serves as a marker for Spring to recognize this interface as a component that provides CRUD for the associated entity
public interface StudentRepository extends JpaRepository<Student, Long> //specify the instance that the entity manage and primary key type
{
    @Query("SELECT s FROM Student s WHERE s.email = ?1") //JPQL, (Student is class name)
    Optional<Student> findStudentByEmail(String email);
}