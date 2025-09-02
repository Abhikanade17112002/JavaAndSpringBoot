import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

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
        Cookie cookie1 = new Cookie("num1",num1+"");
        Cookie cookie2 = new Cookie("num2",num2+"");
        Cookie cookie3 = new Cookie("num3",num3+"");
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
        resp.addCookie(cookie3);
        resp.sendRedirect("/multiply");





    }
}
