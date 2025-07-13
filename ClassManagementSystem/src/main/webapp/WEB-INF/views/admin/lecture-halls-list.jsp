<%-- 
    Document   : lecture-halls-list
    Created on : 8 Mar 2025, 12:10:07 PM
    Author     : Hi
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>


<c:choose>
    <c:when test="${not empty lectureHalls}">
        <c:forEach items="${lectureHalls}" var="hall">
            <div class="list-group-item d-flex justify-content-between align-items-center">
                <div>
                    <h5>${hall.name} - ${hall.floor}</h5>
                    <p class="mb-1">Capacity: ${hall.capacity}</p>
                </div>
                <button class="btn btn-danger btn-sm remove-hall-btn" 
                        data-hall-id="${hall.id}">X</button>
            </div>
        </c:forEach>
    </c:when>
    <c:otherwise>
    </c:otherwise>
</c:choose>