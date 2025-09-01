import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/multiply")
public class MultiplyServlet extends HttpServlet  {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession() ;

        int num1 = (int) session.getAttribute("num1") ;
        int num2 =  (int) session.getAttribute("num2") ;
        int num3 =  (int) session.getAttribute("num3") ;
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter() ;
        printWriter.println("<h1>"+"Num1 ==> "+ num1+"</h1>");
        printWriter.println("<h1>"+"Num2 ==> "+ num2+"</h1>");
        printWriter.println("<h1>"+"Num1 + Num2 ==> "+ num3+"</h1>");
        printWriter.println("<h1>"+"Num1 * Num2 ==> "+ num1*num2+"</h1>");




    }
}
