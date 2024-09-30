package com.example.dao;

import com.example.model.Student;

import java.util.List;

public interface StudentDao
{
    void addStudent(Student Student);
    Student getStudentById(int id);
    List<Student> getAllStudents();
    void updateStudent(int id, Student Student);
    void deleteStudent(int id);
}
