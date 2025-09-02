package com.login;

import com.login.doa.UserDOA;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/verifylogin")
public class VerifyLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username") ;
        String password = req.getParameter("password") ;
        UserDOA doa = new UserDOA() ;
        System.out.println("Here ==> "+username + " " + password );


        if( doa.check(username,password) ){
            HttpSession session = req.getSession() ;
            session.setAttribute("username" , username);
            session.setAttribute("password" , password);

            resp.sendRedirect("/welcome.jsp");

        }
        else {
            resp.sendRedirect("/");
        }



    }
}
