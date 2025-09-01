package com.urlrewriting;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/multiply")
public class MultiplyServlet extends HttpServlet  {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int num1 = Integer.valueOf(req.getParameter("num1")) ;
        int num2 = Integer.valueOf(req.getParameter("num2")) ;
        int num3 = Integer.valueOf(req.getParameter("num3")) ;
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter() ;
        printWriter.println("<h1>"+"Num1 ==> "+ num1+"</h1>");
        printWriter.println("<h1>"+"Num2 ==> "+ num2+"</h1>");
        printWriter.println("<h1>"+"Num1 + Num2 ==> "+ num3+"</h1>");
        printWriter.println("<h1>"+"Num1 * Num2 ==> "+ num1*num2+"</h1>");




    }
}
