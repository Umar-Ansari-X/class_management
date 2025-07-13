<%-- 
    Document   : lectures-list
    Created on : 8 Mar 2025, 12:10:42 PM
    Author     : Hi
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:choose>
    <c:when test="${not empty lectures}">
        <c:forEach items="${lectures}" var="lecture">
    <div class="list-group-item d-flex justify-content-between align-items-center">
        <div>
            <h5>${lecture.name}</h5>
            <p class="mb-1">Professor: ${lecture.professor}</p>
        </div>
        <button class="btn btn-danger btn-sm remove-side-lecture" 
                data-lecture-id="${lecture.id}">
            X
        </button>
    </div>
        </c:forEach>
    </c:when>
    <c:otherwise>
    </c:otherwise>
</c:choose>