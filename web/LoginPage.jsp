<%--
  Created by IntelliJ IDEA.
  User: F_Khan
  Date: 4/21/2022
  Time: 4:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body bgcolor = "#ffffff">

<form method = "POST" action ="LoginServlet">
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
