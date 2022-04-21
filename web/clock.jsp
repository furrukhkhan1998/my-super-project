<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %><%--
  Created by IntelliJ IDEA.
  User: F_Khan
  Date: 4/21/2022
  Time: 3:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Auto Refresh Header Example</title>
</head>
<body>
  <center>
      <h2>Auto Refresh Header Example</h2>
      <%
        response.setIntHeader("refresh", 5);
        Calendar cal = new GregorianCalendar();

        String am_pm;
        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);

        if(cal.get(Calendar.AM_PM) == 0)
          am_pm = "AM";
        else
          am_pm = "PM";
        String CT = hour+":"+ minute +":"+ second +" "+ am_pm;
        out.println("Current Time is: " + CT + "\n");
        response.sendError(407, "Not Authenticated");
      %>
  </center>

</body>
</html>
