import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/multiply")
public class MultiplyServlet extends HttpServlet  {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie cookies[] = req.getCookies() ;

        int num1 = 0  ;
        int num2 = 0  ;
        int num3  = 0 ;

        for( Cookie c : cookies){
            if( c.getName().equals("num1") ){
                num1 = Integer.parseInt( c.getValue()) ;
            }
            else if( c.getName().equals("num2") ){
                num2 = Integer.parseInt( c.getValue()) ;
            }
            else  if( c.getName().equals("num3") ){
                num3 = Integer.parseInt( c.getValue()) ;
            }
        }
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter() ;
        printWriter.println("<h1>"+"Num1 ==> "+ num1+"</h1>");
        printWriter.println("<h1>"+"Num2 ==> "+ num2+"</h1>");
        printWriter.println("<h1>"+"Num1 + Num2 ==> "+ num3+"</h1>");
        printWriter.println("<h1>"+"Num1 * Num2 ==> "+ num1*num2+"</h1>");




    }
}
