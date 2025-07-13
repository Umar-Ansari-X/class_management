<%-- 
    Document   : students
    Created on : 4 Mar 2025, 10:01:49 PM
    Author     : Hi
--%>

<div class="students">
    <h4>Registered Students</h4>
    <div class="list-group">
        <c:forEach items="${students}" var="student">
            <div class="list-group-item">
                <h5>${student.name}</h5>
                <p class="mb-1">${student.email}</p>
                <small>Registered on: 
                    <fmt:formatDate value="${student.registrationDate}" pattern="dd MMM yyyy"/>
                </small>
            </div>
        </c:forEach>
    </div>
</div>