<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 4/22/20
  Time: 2:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Product Show Page"/>
    </jsp:include>

</head>
<body>
    <!-- This is where all the content for the Product Show page will go -->
    <jsp:include page="../partials/navbar.jsp">
        <div class="container">
            <!-- Title of Our Product -->
            <h1>Current Product: ${product.title}</h1>

            <!-- Price of our Product -->
            <p>Price: $${product.priceInCents/100}</p>

            <!-- Description of our Product -->
            <h3>Description</h3>
            <p>${product.description}</p>
        </div>
    </jsp:include>

<%@include file="../partials/scripts.jsp"%>
</body>
</html>
