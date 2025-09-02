package com.studentapp.servlets;

import com.studentapp.doa.StudentDOA;
import com.studentapp.model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/addstudent")
public class AddStudent extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName  = req.getParameter("lastName") ;
        String userName = firstName+"."+lastName ;
        int id = 100 + (int)(Math.random()*100000);
        String email = req.getParameter("email") ;
        String phone = req.getParameter("phone") ;
        String password = req.getParameter("password") ;
        String gender = req.getParameter("gender") ;
        int age = Integer.parseInt(req.getParameter("age"));
        System.out.println( firstName );
        System.out.println( lastName );
        System.out.println( userName );
        System.out.println( id );
        System.out.println( email );
        System.out.println( phone );
        System.out.println( password );
        System.out.println( gender );

        Student newStudent = new Student(id,age,userName,firstName,lastName,gender,email,phone,password) ;
        StudentDOA doa =new StudentDOA();

        if( doa.insertStudent(newStudent)){
            resp.sendRedirect("/welcome.jsp");

        }
        else {
            resp.sendRedirect("/addstudent.jsp");

        }


    }
}
