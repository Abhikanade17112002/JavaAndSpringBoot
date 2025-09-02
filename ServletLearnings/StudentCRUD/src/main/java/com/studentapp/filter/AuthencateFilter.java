package com.studentapp.filter;

import com.studentapp.model.Student;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebFilter(urlPatterns = {"/profile.jsp","/addstudent.jsp","/deletestudent"})
public class AuthencateFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("In Authenticate Filter INIT ");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("In Authenticate Filter");
        HttpServletRequest req = (HttpServletRequest) request ;
        HttpServletResponse res = (HttpServletResponse) response ;
        HttpSession session = req.getSession() ;
        Student student = (Student)session.getAttribute("student") ;

        if( student == null  ){
            res.sendRedirect("/signin.jsp");
        }

        chain.doFilter(request,response);

    }

    @Override
    public void destroy() {
        System.out.println("In Authenticate Filter DESTROY");

    }
}
