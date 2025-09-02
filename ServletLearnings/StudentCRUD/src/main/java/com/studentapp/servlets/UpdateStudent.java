package com.studentapp.servlets;

import com.studentapp.model.Student;
import com.studentapp.doa.StudentDOA;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/updatestudent")
public class UpdateStudent extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get form values
        int id = Integer.parseInt(request.getParameter("id"));

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String userName = firstName + lastName ;

                // Create Student object
        Student student = new Student();
        student.setId(id);
        student.setUserName(userName);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setAge(age);
        student.setGender(gender);
        student.setEmail(email);
        student.setPhone(phone);
        student.setPassword(password);

        // Call DAO
        StudentDOA dao = new StudentDOA();
        boolean updated = dao.updateStudent(student);

        // Redirect after update
        if (updated) {
            response.sendRedirect("/welcome.jsp");
        } else {
            response.sendRedirect("/welcome.jsp");
        }
    }
}