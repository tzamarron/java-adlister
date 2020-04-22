<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 4/21/20
  Time: 11:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="partials/head.jsp"%>
    <title>Login</title>
</head>
<body>
    <%@include file="partials/navbar.jsp"%>
<form method="POST" action="login.jsp">
    <label for="username">Username</label>
    <input id="username" name="username" type="text">
    <br>
    <label for="password">Password</label>
    <input id="password" name="password" type="password">
    <br>
    <button type="submit">Login</button>
</form>

<%
    if (request.getMethod().equalsIgnoreCase("post")){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals("Admin") && password.equals("password")){
            response.sendRedirect("/profile.jsp");
        }
    }
%>
<%@include file="partials/scripts.jsp"%>
</body>
</html>
