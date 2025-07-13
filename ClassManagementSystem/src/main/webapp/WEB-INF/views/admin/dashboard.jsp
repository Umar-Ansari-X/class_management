<%-- 
    Document   : dashboard
    Created on : 28 Feb 2025, 6:16:17 PM
    Author     : Hi
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin Dashboard</title>
    

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    
    <link href="${pageContext.request.contextPath}/resources/css/admin.css" rel="stylesheet">
</head>

<style>
    
                .col-md-8 {
            color: #2c3e50;
            font-weight: 700;
            text-align: center;
            margin-bottom: 0.5rem;
        }
        

    
</style>

<body>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-2 bg-light sidebar">
                <jsp:include page="/WEB-INF/views/includes/sidebar.jsp"/>
            </div>

            <div class="col-md-8">
                <h3>Lecture Halls (<span id="currentDayDisplay">Monday</span>)</h3>
                
                <div id="noLectureHallsMessage" class="alert alert-info" style="display: none;">
                    No Lecture Halls Added Yet.
                </div>

<table id="lectureHallsList" class="table table-striped table-bordered">
    <thead>
        <tr>
            <th>Building Name</th>
            <th>Room No.</th>
            <th>Capacity</th>
            <th>9 AM Lecture</th>
            <th>Students</th>
            <th>11 AM Lecture</th>
            <th>Students</th>
            <th>1 PM Lecture</th>
            <th>Students</th>
            <th>3 PM Lecture</th>
            <th>Students</th>
            <th>5 PM Lecture</th>
            <th>Students</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="hall" items="${lectureHalls}">
            <tr>
                <td>
                    <div id="students_${hall.id}">
                        <button class="btn btn-info btn-sm assign-students"
                                data-hall-id="${hall.id}"
                                data-capacity="${hall.capacity}"
                                onclick="showStudentModal(${hall.id}, ${hall.capacity})">
                            Assign Students (${currentStudentCounts[hall.id]})
                        </button>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
                
                
                
            </div>

            <div class="col-md-2">
                <div class="day-selector">
                    <div class="day-circle" data-day="monday">Mon</div>
                    <div class="day-circle" data-day="tuesday">Tue</div>
                    <div class="day-circle" data-day="wednesday">Wed</div>
                    <div class="day-circle" data-day="thursday">Thu</div>
                    <div class="day-circle" data-day="friday">Fri</div>
                </div>
            </div>
        </div>
    </div>
            
            <div class="modal fade" id="studentAssignmentModal" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
      <div class="modal-header d-flex justify-content-between align-items-center">
        <h5 class="modal-title mb-0">Manage Students</h5>
        <input type="text"
               id="studentSearch"
               class="form-control form-control-sm ml-3"
               style="max-width: 200px;"
               placeholder="Search by ID">
        <button type="button" class="close ml-2" data-dismiss="modal">
          <span>&times;</span>
        </button>
      </div>
            <div class="modal-body">
                <div id="capacityAlert" class="alert alert-danger" style="display: none;">
                    Cannot exceed hall capacity!
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <h6>Available Students</h6>
                        <div id="availableStudents" class="student-list"></div>
                    </div>
                    <div class="col-md-6">
                        <h6>Assigned Students</h6>
                        <div id="assignedStudents" class="student-list"></div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
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

    <script src="${pageContext.request.contextPath}/resources/js/admin.js"></script>
</body>
</html>