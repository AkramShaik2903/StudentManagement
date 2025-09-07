package com.akram.projects.StudentManagementSystem.repository;

import com.akram.projects.StudentManagementSystem.entity.Student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByAgeGreaterThan(int age);
    List<Student> findByNameContainingIgnoreCase(String name);
    List<Student> findByCourseContainingIgnoreCase(String course);
}
