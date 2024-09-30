package com.example;

import com.example.dao.StudentDaoImplementation;
import com.example.model.Student;

import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        StudentDaoImplementation dao = new StudentDaoImplementation();

        //Add data into database
        {
            Student student = new Student();
            student.setId(103);
            student.setName("Musaib");
            student.setEmail("musaib@gmail.com");
            dao.addStudent(student);
        }

        //fetch all the data from database
        {
            List<Student> list = dao.getAllStudents();
            for(Student student : list) {
                System.out.println(student);
            }
        }

        //fetching a student by id from database
        {
            int id = 0;
            Student student = dao.getStudentById(id);
            System.out.println(student);
        }

    }
}
