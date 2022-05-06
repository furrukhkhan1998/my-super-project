package app.servlets;


import app.SessionHandling.ExampleBind;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        HttpSession session = request.getSession();
        String username = request.getParameter("j_username");
        String password = request.getParameter("j_password");

        session.setAttribute("Username",username);
        session.setAttribute("Password", password);

        String error = null;
        HashMap<String, String> logins = (HashMap<String, String>) this.getServletContext().getAttribute("Logins"); //retrieve logins hashmap from app context
        if(logins == null){ //if does not exist then create new hashmap and add user
            logins = new HashMap<String, String>();
            System.out.println("Session Map created and added to app context!");
            logins.put((String) session.getAttribute("Username"), (String) session.getAttribute("Password"));
            this.getServletContext().setAttribute("Logins", logins);
        }
        else{ //if exists then send error message if user already exists
            System.out.println("Hashmap exists! Searching for loggedIn users!");
            System.out.println(logins.isEmpty());
            System.out.println(logins.get(username));
            if(logins.containsKey((String) username)){
                error = "<h1>MULTIPLE LOGINS NOT ALLOWED<h1>";
                System.out.println("Multiple Login ERROR!");
                response.addHeader("Error", error);
                StringBuffer reqURL = new StringBuffer();
                reqURL.append(request.getContextPath());
                reqURL.append("/j_security_check");
                reqURL.append("?");
                reqURL.append("j_username");
                reqURL.append("=");
                reqURL.append("");
                reqURL.append("&");
                reqURL.append("j_password");
                reqURL.append("=");
                reqURL.append(java.net.URLEncoder.encode("", "UTF-8"));
                response.sendRedirect(response.encodeRedirectURL(reqURL.toString()));
                return;
            }
            else{ //add user to map
                logins.put((String) session.getAttribute("Username"), (String) session.getAttribute("Password"));
                this.getServletContext().setAttribute("Logins", logins);
            }
        }
        StringBuffer reqURL = new StringBuffer();
        reqURL.append(request.getContextPath());
        reqURL.append("/j_security_check");
        reqURL.append("?");
        reqURL.append("j_username");
        reqURL.append("=");
        reqURL.append(username);
        reqURL.append("&");
        reqURL.append("j_password");
        reqURL.append("=");
        reqURL.append(java.net.URLEncoder.encode(password, "UTF-8"));
        response.sendRedirect(response.encodeRedirectURL(reqURL.toString()));
    }
}
