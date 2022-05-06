package app.servlets;

import app.SessionHandling.ExampleBind;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //sets sessions variables
        HttpSession session = req.getSession(false);

        if(session == null){
            session = req.getSession(true);
        }
        boolean contains = false;

        Enumeration<String> names1 = session.getAttributeNames();
        while(names1.hasMoreElements()){
            System.out.println("Session attribute = " + names1.nextElement().toString());
        }

        Enumeration<String> names = session.getAttributeNames();
        while(names.hasMoreElements()){
            if(names.nextElement().equals("exampleBind")){
                System.out.println("ExampleBind found");
                contains = true;
            }
        }
        if(!contains){
            System.out.println("Example bind is being set");
            ExampleBind exampleBind = new ExampleBind();
            session.setAttribute("exampleBind", exampleBind);
        }
        resp.sendRedirect(req.getContextPath() + "/home.jsp");
    }
}
