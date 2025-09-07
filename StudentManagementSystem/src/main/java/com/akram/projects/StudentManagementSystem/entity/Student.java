package com.akram.projects.StudentManagementSystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @NotBlank(message="Name cannot be empty")
    private String name;
    @Email(message="Invalid Email format")
    private String email;
    @Min(value=18,message = "Must be atleast 18 years old")
    private int age;
    @NotBlank(message = "Course cannot be empty")
    private String course;
}
