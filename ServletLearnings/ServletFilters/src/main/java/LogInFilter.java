import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.io.PrintWriter;


@WebFilter("/login.jsp")
public class LogInFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("InIt Called");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        PrintWriter pw = response.getWriter() ;
        RequestDispatcher rd = request.getRequestDispatcher("/");

        HttpServletRequest req = (HttpServletRequest)request ;

        String username = req.getParameter("username");
        String password = req.getParameter("password") ;
        boolean isValid = "admin".equals(username) && "Pass".equals(password);

        if( isValid ){
            chain.doFilter(request,response);

        }
        else {
            pw.println("<h1>Invalid UserName Or Password</h1>");
            rd.include(request,response);
        }
    }

    @Override
    public void destroy() {
        System.out.println("Destroy Called");
    }
}
