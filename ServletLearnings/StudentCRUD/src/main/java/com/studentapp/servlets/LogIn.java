package com.studentapp.servlets;

import com.studentapp.doa.StudentDOA;
import com.studentapp.model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet("/signin")
public class LogIn extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username") ;
        String password = req.getParameter("password" );

        if( username != null && password != null ){
            StudentDOA studentDOA = new StudentDOA() ;
            Student student = studentDOA.getStudent(username,password) ;
            System.out.println(student);

            if( student != null ){

                HttpSession session = req.getSession() ;
                session.setAttribute("student",student);

                resp.sendRedirect("/welcome.jsp");

            }
            else {
                resp.sendRedirect("/signup.jsp");
            }
        }


    }
}
