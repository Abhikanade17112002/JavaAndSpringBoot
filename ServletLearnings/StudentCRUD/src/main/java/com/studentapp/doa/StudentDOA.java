package com.studentapp.doa;

import com.studentapp.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDOA {


    private final String url = "jdbc:mysql://localhost:3306/studentdb" ;
    private final String usernameDB = "root" ;
    private final String passwordDB = "Encora@12345" ;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Student getStudent(String username, String password) {
        Student student = null;
        String sql = "SELECT * FROM students WHERE userName = ? AND password = ?";

        try (Connection conn = DriverManager.getConnection(url, usernameDB, passwordDB);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                student = new Student();
                student.setId(rs.getInt("id"));
                student.setUserName(rs.getString("userName"));
                student.setFirstName(rs.getString("firstName"));
                student.setLastName(rs.getString("lastName"));
                student.setAge(rs.getInt("age"));
                student.setGender(rs.getString("gender"));
                student.setEmail(rs.getString("email"));
                student.setPhone(rs.getString("phone"));
                student.setPassword(rs.getString("password"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }

    public Student getStudentWithUserName(String username) {
        Student student = null;
        String sql = "SELECT * FROM students WHERE userName = ?";

        try (Connection conn = DriverManager.getConnection(url, usernameDB, passwordDB);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                student = new Student();
                student.setId(rs.getInt("id"));
                student.setUserName(rs.getString("userName"));
                student.setFirstName(rs.getString("firstName"));
                student.setLastName(rs.getString("lastName"));
                student.setAge(rs.getInt("age"));
                student.setGender(rs.getString("gender"));
                student.setEmail(rs.getString("email"));
                student.setPhone(rs.getString("phone"));
                student.setPassword(rs.getString("password"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }

    public List<Student> getStudents(  ){

        try{
            Connection connection = DriverManager.getConnection(url,usernameDB,passwordDB);
            String qeuery = "SELECT * FROM students" ;
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(qeuery);

            List<Student> students = new ArrayList<>();

            while (rs.next()) {
                int id = rs.getInt("id");
                String userName = rs.getString("userName");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                int age = rs.getInt("age");
                String gender = rs.getString("gender");
                String email = rs.getString("email");
                String phone = rs.getString("phone");

                // Create Student object
                Student newStudent = new Student();
                newStudent.setId(id);
                newStudent.setUserName(userName);
                newStudent.setFirstName(firstName);
                newStudent.setLastName(lastName);
                newStudent.setAge(age);
                newStudent.setGender(gender);
                newStudent.setEmail(email);
                newStudent.setPhone(phone);

                // Add to list
                students.add(newStudent);
            }
            return  students ;
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return new ArrayList<>();
    }
    public boolean updateStudent(Student student) {
        String sql = "UPDATE students SET userName = ?, firstName = ?, lastName = ?, age = ?, " +
                "gender = ?, email = ?, phone = ?, password = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, usernameDB, passwordDB);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, student.getUserName());
            ps.setString(2, student.getFirstName());
            ps.setString(3, student.getLastName());
            ps.setInt(4, student.getAge());
            ps.setString(5, student.getGender());
            ps.setString(6, student.getEmail());
            ps.setString(7, student.getPhone());
            ps.setString(8, student.getPassword());
            ps.setInt(9, student.getId()); // where condition

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean insertStudent(Student student) {
        String sql = "INSERT INTO students (userName, firstName, lastName, age, gender, email, phone, password) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, usernameDB, passwordDB);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, student.getUserName());
            ps.setString(2, student.getFirstName());
            ps.setString(3, student.getLastName());
            ps.setInt(4, student.getAge());
            ps.setString(5, student.getGender());
            ps.setString(6, student.getEmail());
            ps.setString(7, student.getPhone());
            ps.setString(8, student.getPassword());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean deleteStudent(String username) {
        String sql = "DELETE FROM students WHERE userName = ?";

        try (Connection conn = DriverManager.getConnection(url, usernameDB, passwordDB);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0; // true if a row was deleted

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }



}
