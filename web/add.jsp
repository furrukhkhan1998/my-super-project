<%--
  Created by IntelliJ IDEA.
  User: F_Khan
  Date: 2/28/2022
  Time: 3:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Page</title>
</head>
<body>

    <table border="1" align = "center">
        <tr>
            <th>Session Info</th><th>Value</th>
        </tr>
        <tr>
            <td>id</td>
            <%
                out.print("<td>" + session.getId() + "</td>");
            %>
        </tr>
        <tr>
            <td>Creation Time</td>
            <%
                out.print("<td>" + session.getCreationTime() + "</td>");
            %>
        </tr>
        <tr>
            <td>Time of last access</td>
            <%
                out.print("<td>" + session.getLastAccessedTime() + "</td>");
            %>
        </tr>
        <tr>
            <td>Visit Count</td>
            <%
                out.print("<td>" + session.getAttribute("VisitCount") + "</td>");
            %>
        </tr>

    </table>



<form method="post">
    <label>Name:
        <input type="text" name="name"><br />
    </label>

    <label>Password:
        <input type="password" name="pass"><br />
    </label>
    <button type="submit">Submit</button>
</form>



</body>
</html>
