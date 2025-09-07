package com.akram.projects.StudentManagementSystem.controller;

import com.akram.projects.StudentManagementSystem.entity.Student;
import com.akram.projects.StudentManagementSystem.service.StudentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;
    @PostMapping
    public Student create(@RequestBody @Valid Student student){
        return studentService.createStudent(student);
    }

    @GetMapping
    public List<Student> getAll(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable long id){
        return studentService.getStudentById(id)
                .orElseThrow(()-> new RuntimeException("Student not found"));
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable long id,@RequestBody @Valid Student student){
        return studentService.updateStudent(id,student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable long id){
        studentService.deleteStudent(id);
    }

    @GetMapping("/name/{name}")
    public List<Student> findByName(@PathVariable String name){
        return studentService.findByName(name);
    }

    @GetMapping("/course/{course}")
    public List<Student> findByCourse(@PathVariable String course){
        return studentService.findByCourse(course);
    }

    @GetMapping("/age/{age}")
    public List<Student> findByAgeGreaterThan(@PathVariable int age){
        return studentService.findByAgeGreaterThan(age);
    }

    @GetMapping("/sorted")
    public List<Student> getAllStudentsSortedBy(@RequestParam String field){
        return studentService.getAllStudentsSortedBy(field);
    }
}
