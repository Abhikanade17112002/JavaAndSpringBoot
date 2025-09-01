package com.urlrewriting;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/submit")
public class AddServlet  extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException, ServletException {
      int num1 = Integer.valueOf(req.getParameter("num1"));
      int num2 = Integer.valueOf(req.getParameter("num2"));

        PrintWriter printWriter = resp.getWriter() ;
        int num3 = num1 + num2 ;

        resp.sendRedirect("/multiply?num1="+num1+"&num2="+num2+"&num3="+num3);





    }
}
