package com.studentapp.servlets;

import com.studentapp.doa.StudentDOA;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/deletestudent")
public class DeleteStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        StudentDOA doa = new StudentDOA();

        if( doa.deleteStudent(username) ){
            resp.sendRedirect("/welcome.jsp");
        }
        else{
            resp.sendRedirect("/signin.jsp");

        }
    }
}
