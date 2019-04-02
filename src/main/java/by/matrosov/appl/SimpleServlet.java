package by.matrosov.appl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

//navigate to
//localhost:8080/java_servlet_war_exploded/servlet
//to see the "hello servlet"
//also example implements SessionListener and count active sessions
@WebServlet(
        urlPatterns = "/servlet",
        initParams = {
                @WebInitParam(name = "firstParam", value = "Hello"),
                @WebInitParam(name = "secondParam", value = "Parameters")
        }
)
public class SimpleServlet extends HttpServlet implements HttpSessionListener {

    private static int sessionsCount;

    public static int getSessionsCount() {
        return sessionsCount;
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        sessionsCount++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        sessionsCount--;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Hello Servlet Get</h1>");
        out.println("</body>");
        out.println("</html>");

        PrintWriter pw = resp.getWriter();
        pw.println(getServletConfig().getInitParameter("firstParam"));
        pw.println(getServletConfig().getInitParameter("secondParam"));

    }

}
