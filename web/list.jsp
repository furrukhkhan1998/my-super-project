<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: F_Khan
  Date: 2/28/2022
  Time: 3:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Page</title>
</head>
<body>
    <ul>
        <%
            List<String> names = (List<String>) request.getAttribute("userNames");

            if(names != null && !names.isEmpty()){
                for(String s : names){
                    out.println("<li>" + s + "</li>");
                }
            }else
            {
                out.println("<p>There are no users yet!</p>");
            }
        %>
    </ul>
    <button onclick="location.href='home.html'">Home</button>
</body>
</html>
