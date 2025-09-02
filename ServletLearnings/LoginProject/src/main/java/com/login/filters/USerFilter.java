package com.login.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = {"/welcome.jsp" , "/video.jsp"})
public class USerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Indside INIT");
    }

    @Override
    public void destroy() {
        System.out.println("Indside DESTROY");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request ;
        HttpServletResponse resp = (HttpServletResponse) response ;
        HttpSession session = req.getSession() ;
        String username = (String)session.getAttribute("username") ;

        if( username == null || username.isEmpty() ){
            resp.sendRedirect("/");
        }
        System.out.println("From Filter " + username);
        chain.doFilter(request,response);
    }
}
