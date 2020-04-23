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

<%--    <c:forEach var="ad" items="${ads}">--%>
<%--        <div>--%>
<%--            <h2><c:out value="${ad.title}" /></h2>--%>
<%--            <p><c:out value="Description: ${ad.description}" /></p>--%>
<%--        </div>--%>
<%--    </c:forEach>--%>

    <div class="container">
        <c:forEach var="ad" items="${ads}">
            <div class="card border mx-4" style="width: 18rem;">
                <img src="..." class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">${ad.title}</h5>
                    <p class="card-text">${ad.description}</p>
                    <a href="#" class="btn btn-primary">Buy Now</a>
                </div>
            </div>
        </c:forEach>
    </div>


</body>
</html>






