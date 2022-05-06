package app.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        //request.getRequestDispatcher("link.html").include(request, response);



        HttpSession session = request.getSession(false);
        HashMap<String,String> sessionMap = (HashMap<String,String>) this.getServletContext().getAttribute("Logins");
        String name = (String) session.getAttribute("Username");
        System.out.println(name + " is logging out!");
        System.out.println(sessionMap.containsKey(name));
        sessionMap.remove(name);
        this.getServletContext().removeAttribute("Logins");
        this.getServletContext().setAttribute("Logins", sessionMap);
        session.removeAttribute("exampleBind");
        System.out.println("You are successfully logged out!");
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
}
