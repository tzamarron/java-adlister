<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="View all ads"/>
    </jsp:include>
</head>
<body>
<!-- This is where all the content for the Product Show page will go -->
    <%@include file="../partials/navbar.jsp"%>
    <h1>All Adds : </h1>

    <c:forEach var="ad" items="${ads}">
        <div>
            <h2><c:out value="${ad.title}" /></h2>
            <p><c:out value="Description: ${ad.description}" /></p>
        </div>
    </c:forEach>
</body>
</html>
