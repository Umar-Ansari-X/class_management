<%-- 
    Document   : dashboard
    Created on : 28 Feb 2025, 6:17:07 PM
    Author     : Hi
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User Dashboard</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center mb-4">Your Weekly Schedule</h2>
        
        <div class="table-responsive">
            <table class="table table-bordered schedule-table">
                <thead class="thead-light">
                    <tr>
                        <th>Time</th>
                        <th>Monday</th>
                        <th>Tuesday</th>
                        <th>Wednesday</th>
                        <th>Thursday</th>
                        <th>Friday</th>
                    </tr>
                </thead>
                <tbody>
                    <c:set var="timeSlots" value="9-11 AM,11-1 PM,1-3 PM,3-5 PM,5-7 PM" />
                    
                    <c:forEach items="${timeSlots.split(',')}" var="timeRange" varStatus="loop">
                        <tr>
                            <td class="time-slot">${timeRange}</td>
                            
                            <c:forEach items="${['monday','tuesday','wednesday','thursday','friday']}" var="day">
                                <td class="lecture-info">
                                    <c:set var="timeSlot" value="${day}_${['9am','11am','1pm','3pm','5pm'][loop.index]}" />
                                    
                                    <c:if test="${not empty schedule[timeSlot]}">
                                        <div class="lecture-details">
                                            <h6>${schedule[timeSlot].lectureName}</h6>
                                            <p class="mb-1">
                                                <strong>Professor:</strong> ${schedule[timeSlot].professor}<br>
                                                <strong>Room:</strong> ${schedule[timeSlot].buildingName} - ${schedule[timeSlot].roomNumber}
                                            </p>
                                        </div>
                                    </c:if>
                                </td>
                            </c:forEach>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
                    
             <a href="${pageContext.request.contextPath}/logout"
   class="btn btn-danger"
   style="
     position: fixed;
     bottom: 20px;
     right: 20px;
     z-index: 1050; 
   ">
  Logout
</a>                   
                    
</body>
</html>
