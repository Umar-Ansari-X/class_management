<%-- 
    Document   : sidebar
    Created on : 4 Mar 2025, 10:02:10 PM
    Author     : Hi
--%>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
            .sidebar-sticky {
            box-shadow: 0 0.5rem 1rem rgba(0, 0, 0, 0.1);
        }
    
    
</style>

<div class="sidebar-sticky d-flex flex-column" style="height: 100vh;">
    <ul class="nav flex-column">
        <li class="nav-item">
            <button class="btn btn-link nav-link active" data-target="lecture-halls">
                Lecture Halls
            </button>
        </li>
        <li class="nav-item">
            <button class="btn btn-link nav-link" data-target="lectures">
                Lectures
            </button>
        </li>
        <li class="nav-item">
            <button class="btn btn-link nav-link" data-target="students">
                Students
            </button>
        </li>
    </ul>

    <div id="listArea" class="flex-grow-1 overflow-auto" style="flex: 1;">
        <div class="alert alert-info" id="emptyMessage" style="display: none;">
            No items added yet. Click "Add" to get started!
        </div>
        <div id="listContent">
        </div>
    </div>

    <div class="mt-auto" style="position: sticky; bottom: 0; background: white; padding: 10px;">
        <button id="addButton" class="btn btn-primary btn-block" 
                 data-target="#mainModal"
                style="display: none;"> 
            Add Lecture Hall
        </button>
    </div>
</div>


<div class="modal fade" id="mainModal" tabindex="-1" role="dialog" aria-labelledby="mainModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mainModalLabel">Add Lecture Hall</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form id="mainForm" method="post">
                <div class="modal-body" id="modalBody">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Save</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    
$(document).on("click", ".remove-side-lecture", function () {
    const lectureId = $(this).data("lecture-id");

    if (!confirm("Are you sure you want to delete this lecture?")) {
        return;
    }

    $.post("removeSideLecture", { lectureId: lectureId })
        .done(function (response) {
            if (response.trim() === "success") {
                alert("Lecture removed successfully.");
                location.reload(); 
            } else {
                alert("Failed to remove lecture.");
            }
        });
});



$(document).on('click', '.remove-hall-btn', function () {
    const hallId = $(this).data('hall-id');

    if (confirm("Are you sure you want to remove this lecture hall?")) {
        $.ajax({
            url: 'removeLectureHall',
            method: 'POST',
            data: { hallId: hallId },
            success: function (response) {
                if (response.trim() === "success") {
                    alert('Lecture hall removed successfully!');
                    location.reload(); 
                } else {
                    alert('Failed to remove lecture hall.');
                }
            },
            error: function () {
                alert('Error communicating with the server.');
            }
        });
    }
});
</script>
