<%-- 
    Document   : index
    Created on : 28 Feb 2025, 2:46:53 PM
    Author     : Hi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Class Management System</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<style>
            .text-center {
            color: #2c3e50;
            font-weight: 700;
            text-align: center;
        }
    
</style>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Class Management System</h1>
        <div class="text-center mt-4">
            <a href="${pageContext.request.contextPath}/login.jsp" class="btn btn-primary">Login</a>
            <a href="${pageContext.request.contextPath}/register.jsp" class="btn btn-secondary">Register</a>
        </div>
    </div>
</body>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
</html>