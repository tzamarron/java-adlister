<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 4/21/20
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pick a color</title>
</head>
<body>
<form method="GET" action="usercolor.jsp">
    <label for="user_color">Color</label>
    <input id="user_color" name="user_color" type="text" placeholder="Enter your favorite color.">
    <br>
    <button type="submit">Submit</button>
</form>
<%--<%--%>
<%--    String userColor;--%>
<%--    if(request.getParameter("user_color") != null){--%>
<%--        userColor = request.getParameter("colorChoice");--%>
<%--        response.sendRedirect("/picked-color.jsp?userColor=" + userColor);--%>
<%--    }--%>
<%--%>--%>
</body>
</html>
