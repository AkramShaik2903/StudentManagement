package com.akram.projects.StudentManagementSystem.service;

import com.akram.projects.StudentManagementSystem.entity.Student;
import com.akram.projects.StudentManagementSystem.repository.StudentRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(long id){
        return studentRepository.findById(id);
    }

    public Student updateStudent(long id,Student updatedStudent){
        Student student=studentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Student not found"));
        student.setName(updatedStudent.getName());
        student.setEmail(updatedStudent.getEmail());
        student.setAge(updatedStudent.getAge());
        student.setCourse(updatedStudent.getCourse());
        return studentRepository.save(student);
    }

    public void deleteStudent(long id){
        studentRepository.deleteById(id);
    }

    public List<Student> findByAgeGreaterThan(int age){
        return studentRepository.findByAgeGreaterThan(age);
    }

    public List<Student> findByName(String name){
        return studentRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Student> findByCourse(String course){
        return studentRepository.findByCourseContainingIgnoreCase(course);
    }

    public List<Student> getAllStudentsSortedBy(String field){
        return studentRepository.findAll(Sort.by(Sort.Direction.ASC,field));
    }
}
