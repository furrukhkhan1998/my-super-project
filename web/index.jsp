<!DOCTYPE html>
<html lang = "en">
<head>
  <meta charset="UTF-8">
  <title>Servlet Login Example</title>
</head>
<% String path = request.getContextPath() + "/HomeServlet";
  System.out.println(path);
  if(session == null){
    session = request.getSession();
    System.out.println("creating new session!");
  }

%>
<body>

<h1>Login App using HttpSession</h1>
<a href= <% out.print(path); %> >Profile</a>
</body>
</html>
