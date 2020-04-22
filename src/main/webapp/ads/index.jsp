<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 4/22/20
  Time: 4:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../partials/head.jsp"%>
    <title>Ads</title>
</head>
<body>
<!-- This is where all the content for the Product Show page will go -->
    <%@include file="../partials/navbar.jsp"%>
    <h1>All Adds : </h1>

    <c:forEach var="ad" items="${ads}">
        <div>
            <h2>${ad.title}</h2>
            <p>Description: ${ad.description}</p>
        </div>
    </c:forEach>
</body>
</html>
