<%-- 
    Document   : lectures
    Created on : 4 Mar 2025, 10:01:31 PM
    Author     : Hi
--%>

<div class="lectures">
    <h4>Lectures</h4>
<script type="application/json" id="lectureHallsData">
    [
        <c:forEach items="${lectureHalls}" var="hall" varStatus="loop">
            {
                "id": ${hall.id},
                "name": "${hall.name}",
                "capacity": ${hall.capacity},
                "mondayAvailability": ${hall.mondayAvailability},
                "tuesdayAvailability": ${hall.tuesdayAvailability},
                "wednesdayAvailability": ${hall.wednesdayAvailability},
                "thursdayAvailability": ${hall.thursdayAvailability},
                "fridayAvailability": ${hall.fridayAvailability},
                "saturdayAvailability": ${hall.saturdayAvailability},
                "sundayAvailability": ${hall.sundayAvailability}
            }${!loop.last ? ',' : ''}
        </c:forEach>
    ]
</script>
This will genera
    <c:choose>
        <c:when test="${empty lectures}">
            <div class="alert alert-info">
                No lectures scheduled yet. Click "Add Lecture" to create one!
            </div>
        </c:when>
        <c:otherwise>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Lecture Hall</th>
                        <th>Day</th>
                        <th>Time</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${lectures}" var="lecture">
                        <tr>
                            <td>${lecture.name}</td>
                            <td>${lecture.hall.name}</td>
                            <td>${lecture.dayOfWeek}</td>
                            <td>${lecture.startTime} - ${lecture.endTime}</td>
                            <td>
                                <button class="btn btn-sm btn-info" onclick="addStudentsToLecture(${lecture.id})">
                                    Add Students
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
                <h5 class="modal-title">Add Lecture</h5>
                <button type="button" class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            <form action="${pageContext.request.contextPath}/add-lecture" method="post">
                <div class="modal-body">
                    <div class="form-group">
                        <label>Subject</label>
                        <input type="text" class="form-control" name="subject" required>
                    </div>
                    <div class="form-group">
                        <label>Professor</label>
                        <input type="text" class="form-control" name="professor" required>
                    </div>
                    <div class="form-group">
                        <label>Credits</label>
                        <input type="number" class="form-control" name="credits" required>
                    </div>
                    <div class="form-group">
                        <label>Lecture Hall</label>
                        <select class="form-control" name="hallId" required>
                            <c:forEach items="${lectureHalls}" var="hall">
                                <option value="${hall.id}">${hall.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Add Lecture</button>
                </div>
            </form>
        </div>
    </div>
</div>                    