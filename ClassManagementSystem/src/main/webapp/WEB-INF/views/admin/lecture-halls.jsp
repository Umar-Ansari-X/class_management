<%-- 
    Document   : lecture-halls
    Created on : 4 Mar 2025, 10:01:24 PM
    Author     : Hi
--%>

<div class="lecture-halls">
    <h4>Lecture Halls</h4>
    <c:choose>
        <c:when test="${empty lectureHalls}">
            <div class="alert alert-info">
                No lecture halls added yet. Click "Add Lecture Hall" to get started!
            </div>
        </c:when>
        <c:otherwise>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Capacity</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${lectureHalls}" var="hall">
                        <tr>
                            <td>${hall.name}</td>
                            <td>${hall.capacity}</td>
                            <td>
                                <button class="btn btn-sm btn-info" onclick="addLectureToHall(${hall.id})">
                                    Add Lecture
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
</div>
                    
                    
<div class="modal fade" id="addModal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Add Lecture Hall</h5>
                <button type="button" class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            <form action="${pageContext.request.contextPath}/add-lecture-hall" method="post">
                <div class="modal-body">
                    <div class="form-group">
                        <label>Building Name</label>
                        <input type="text" class="form-control" name="buildingName" required>
                    </div>
                    <div class="form-group">
                        <label>Floor Number</label>
                        <input type="number" class="form-control" name="floorNumber" required>
                    </div>
                    <div class="form-group">
                        <label>Number of Seats</label>
                        <input type="number" class="form-control" name="capacity" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Add Hall</button>
                </div>
            </form>
        </div>
    </div>
</div>             