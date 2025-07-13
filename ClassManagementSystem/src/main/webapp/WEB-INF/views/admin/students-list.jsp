<%-- 
    Document   : students-list
    Created on : 8 Mar 2025, 12:10:51 PM
    Author     : Hi
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:choose>
    <c:when test="${not empty students}">
        <c:forEach items="${students}" var="student">
            <div class="list-group-item">
                <h5>${student.name}</h5>
            </div>
        </c:forEach>
    </c:when>
    <c:otherwise>
    </c:otherwise>
</c:choose>