<%--
  Created by IntelliJ IDEA.
  User: F_Khan
  Date: 4/21/2022
  Time: 4:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body bgcolor = "#ffffff">

<h1>INVALID LOGIN!!!</h1>
<h1><% out.print("The error is " + request.getHeader("T")); %></h1>
<form method = "POST" action ="j_security_check">
    <table border = "0">
        <tr>
            <td>Login</td>
            <td><input type = "text" name="j_username"></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type = "password" name="j_password"></td>
        </tr>
    </table>
    <input type = "submit" value = "Login!">

</form>

</body>
</html>
