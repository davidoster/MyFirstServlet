<%-- 
    Document   : secure
    Created on : May 19, 2021, 8:48:38 PM
    Author     : George.Pasparakis
--%>


<%@page import="models.UserLogin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to the super secure page!!!!</h1>
        Username: <%= request.getAttribute("username") %>
        <% 
            UserLogin ul = new UserLogin();
            ul = (UserLogin)request.getAttribute("userlogin");
            out.println("<p>Password: " + ul.getPassword() + "</p>");
         %>
    </body>
</html>
