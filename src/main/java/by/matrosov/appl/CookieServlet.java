package by.matrosov.appl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//navigate to
//localhost:8080/java_servlet_war_exploded/cookie
//to create a simple Cookie, time to live is one hour, and store in client computer.
@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

        Cookie cookie = new Cookie("url","mycookie");
        cookie.setMaxAge(60*60);
        resp.addCookie(cookie);

        pw.println("Cookies created");
    }
}
