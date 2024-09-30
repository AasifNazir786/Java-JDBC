package com.example.dao;

import com.example.model.Student;
import com.example.utilities.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImplementation implements StudentDao
{
    @Override
    public void addStudent(Student student) {
        String query = "INSERT INTO students (id, name, email) VALUES (?, ?, ?)";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, student.getId());
            pstmt.setString(2, student.getName());
            pstmt.setString(3, student.getEmail());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    @Override
    public Student getStudentById(int id) {
        return null;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DBUtil.getConnection();
            pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Student student = new Student();
                student.setId(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setEmail(rs.getString(3));
                students.add(student);
            }
        }catch(SQLException e){
            System.out.println("the error is: " + e.getMessage());
        }
        return students;
    }

    @Override
    public void updateStudent(int id, Student Student) {

    }

    @Override
    public void deleteStudent(int id) {

    }
}
