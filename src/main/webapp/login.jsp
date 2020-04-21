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
    <title>Login</title>
</head>
<body>
<form method="POST" action="login.jsp">
    <section id="email_pass">
        <label for="user_email">Email</label>
        <input id="user_email" name="user_email" type="text">
        <br>
        <label for="password">Password</label>
        <input id="password" name="password" type="password">
    </section>
    <button type="submit">Login</button>
</form>


</body>
</html>
