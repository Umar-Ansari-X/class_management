<%-- 
    Document   : error
    Created on : 28 Feb 2025, 9:57:57 PM
    Author     : Hi
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center text-danger">Oops! Something went wrong.</h1>
        <p class="text-center">We couldn't find the page you're looking for.</p>
        <p class="text-center">Error Code: ${pageContext.errorData.statusCode}</p>
        <p class="text-center">Request URI: ${pageContext.errorData.requestURI}</p>
        <div class="text-center mt-4">
            <a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-primary">Go Home</a>
        </div>
    </div>
</body>
</html>
