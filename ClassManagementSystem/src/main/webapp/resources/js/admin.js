let currentSection = 'lecture-halls';
let lectureHalls = [];  
let lectures = [];  
let studentsData = [];
let currentDay = 'monday';
let currentHallId = null;
let currentCapacity = 0;
let currentTimeSlot = null;
const timeSlots = ['9am', '11am', '1pm', '3pm', '5pm'];

function loadContent(target) {
    currentSection = target;
    fetch(`admin/${target}-list`) 
        .then(response => response.text())
        .then(html => {
            const listContent = document.getElementById('listContent');
            const emptyMessage = document.getElementById('emptyMessage');
            
            
            listContent.innerHTML = html;
            
            console.log(listContent.children);

            if (listContent.children.length === 0) {
                emptyMessage.style.display = 'block';
            } else {
                emptyMessage.style.display = 'none';
            }

            updateAddButtonVisibility(target);
            
            fetchLectureHallsData();
        });
}
function fetchLecturesData() {
    fetch('/ClassManagementSystem/lectures-data')
        .then(response => response.json())
        .then(data => {
            console.log('Lectures Data:', data); 
            lectures = data;
        });
}
function updateAddButtonVisibility(target) {
    const addButton = document.getElementById('addButton');
    switch (target) {
        case 'lecture-halls':
            addButton.style.display = 'block';
            addButton.textContent = 'Add Lecture Hall';
            break;
        case 'lectures':
            addButton.style.display = 'block';
            addButton.textContent = 'Add Lecture';
            break;
        case 'students':
            addButton.style.display = 'none'; // Hide for students
            break;
    }
}

function fetchLectureHallsData() {
    Promise.all([
        fetch('/ClassManagementSystem/lecture-halls-data').then(res => res.json()),
        fetch('/ClassManagementSystem/lectures-data').then(res => res.json()),
        fetch('/ClassManagementSystem/students-data').then(res => res.json())
    ]).then(([hallsData, lecturesData]) => {
        console.log('Lecture Halls Data:', hallsData); 
        console.log('Lectures Data:', lecturesData);
        console.log('Students Data:', studentsData);
        lectureHalls = hallsData;
        lectures = lecturesData;
        students = studentsData;
        updateLectureHallsTable('monday'); 
    });
}


document.addEventListener("DOMContentLoaded", function () {
    document.querySelectorAll('.nav-link').forEach(button => {
        button.addEventListener('click', function () {
            const target = this.getAttribute('data-target');
            loadContent(target);
        });
    });

    loadContent(currentSection);
});

document.getElementById('mainForm').addEventListener('submit', function (event) {
    event.preventDefault(); 

    const form = event.target;
    const formData = new FormData(form);


    fetch(form.action, {
        method: 'POST',
        body: formData
    })
    .then(response => {
        if (response.ok) {
            loadContent(currentSection);
            $('#mainModal').modal('hide');
            $('.modal-backdrop').remove();
            form.reset();
        } else {
            response.json().then(errorData => {
                alert('Error adding entry: ' + errorData.message); 
            });
        }
    });
});
    
    
    document.getElementById('addButton').addEventListener('click', function () {
        const modal = document.getElementById('mainModal');
        const form = document.getElementById('mainForm');
        const title = document.getElementById('mainModalLabel');
        const body = document.getElementById('modalBody'); 

        if (!body) {
            console.error("modalBody element not found");
            return;
        }

        body.innerHTML = '';

        switch (currentSection) {
            case 'lecture-halls':
                title.textContent = 'Add Lecture Hall';
                body.innerHTML = `
                    <div class="form-group">
                        <label>Building Name</label>
                        <input type="text" class="form-control" name="buildingName" required>
                    </div>
                    <div class="form-group">
                        <label>Room Number</label>
                        <input type="number" class="form-control" name="floorNumber" required>
                    </div>
                    <div class="form-group">
                        <label>Number of Seats</label>
                        <input type="number" class="form-control" name="capacity" required>
                    </div>
                `;
                form.action = "add-lecture-hall";
                break;

            case 'lectures':
                title.textContent = 'Add Lecture';
                body.innerHTML = `
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

                `;
                form.action = "add-lecture";
                break;
        }

        $('#mainModal').modal('show');
    });




document.querySelectorAll('.day-circle').forEach(button => {
    button.addEventListener('click', function() {
        const selectedDay = this.getAttribute('data-day');
        console.log(`Selected day: ${selectedDay}`);
        
        currentDay = this.getAttribute('data-day');
        const dayNames = {
            monday: 'Monday',
            tuesday: 'Tuesday',
            wednesday: 'Wednesday',
            thursday: 'Thursday',
            friday: 'Friday'
        };

        $('#currentDayDisplay').text(dayNames[currentDay]);


    Promise.all([
        fetch('/ClassManagementSystem/lecture-halls-data').then(res => res.json()),
        fetch('/ClassManagementSystem/lectures-data').then(res => res.json())
    ]).then(([hallsData, lecturesData]) => {
        console.log('Lecture Halls Data:', hallsData); 
        console.log('Lectures Data:', lecturesData);  
        lectureHalls = hallsData;
        lectures = lecturesData;
        updateLectureHallsTable(selectedDay);
    });


        
    });
});

function updateLectureHallsTable(day) {
    const tbody = document.querySelector('#lectureHallsList tbody');
    tbody.innerHTML = '';

    if (lectureHalls.length === 0) {
        const noHallsRow = document.createElement('tr');
        noHallsRow.innerHTML = `<td colspan="${3 + (timeSlots.length * 2)}" class="text-center">No Lecture Halls Added Yet</td>`;
        tbody.appendChild(noHallsRow);
    } else {
        lectureHalls.forEach(hall => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${hall.name}</td>
                <td>${hall.floor}</td>
                <td>${hall.capacity}</td>
            `;

            timeSlots.forEach(timeSlot => {
                const fullTimeSlot = `${day}_${timeSlot}`;
                const lectureId = hall[`${fullTimeSlot}_lecture_id`];
                const studentCount = hall[`${fullTimeSlot}_students`] || 0;
                const lectureName = lectures.find(l => l.id === lectureId)?.name || '';

                row.innerHTML += `
                    <td>
                        <div id="lecture_${hall.id}_${fullTimeSlot}">
                            ${lectureId ? `
                                <span>${lectureName}</span>
                                <span class="remove-lecture" 
                                      onclick="removeLecture(${hall.id}, '${fullTimeSlot}')"
                                      title="Remove Lecture">✖️</span>
                            ` : `
                                <button class="btn btn-primary btn-sm"
                                        onclick="showDropdown('${fullTimeSlot}', ${hall.id})">
                                    Assign
                                </button>
                                <div id="dropdown_${hall.id}_${fullTimeSlot}" style="display: none;">
                                    <select id="lectureSelect_${hall.id}_${fullTimeSlot}">
                                        ${lectures.map(lecture => `
                                            <option value="${lecture.id}">${lecture.name}\nby ${lecture.professor}</option>
                                        `).join('')}
                                    </select>
                                    <button class="btn btn-success btn-sm"
                                            onclick="assignLecture('${fullTimeSlot}', ${hall.id})">
                                        ✔️
                                    </button>
                                </div>
                            `}
                        </div>
                    </td>
                    <td>
                        <button class="btn btn-info btn-sm"
                                onclick="showStudentModal(${hall.id}, ${hall.capacity}, '${fullTimeSlot}')">
                            Students (${studentCount})
                        </button>
                    </td>
                `;
            });

            tbody.appendChild(row);
        });
    }
}


function showDropdown(timeSlot, hallId) {
    document.getElementById(`dropdown_${hallId}_${timeSlot}`).style.display = 'block';
}


function assignLecture(timeSlot, hallId) {
    const selectId = `lectureSelect_${hallId}_${timeSlot}`;
    const lectureId = document.getElementById(selectId).value;
    
    $.ajax({
        type: "POST",
        url: "assignLecture",
        data: {
            hallId: hallId,
            lectureId: lectureId,
            timeSlot: timeSlot
        },
        success: function() {

                const lectureName = document.getElementById(selectId).options[
                    document.getElementById(selectId).selectedIndex
                ].text;
                
                document.getElementById(`lecture_${hallId}_${timeSlot}`).innerHTML = `
                    <span>${lectureName}</span>
                    <span class="remove-lecture" 
                          onclick="removeLecture(${hallId}, '${timeSlot}')"
                          title="Remove Lecture">✖️</span>
                `;
           
        }
    });
}
function removeLecture(hallId, timeSlot) {
    if (confirm('Are you sure you want to remove this lecture?')) {
        $.ajax({
            type: "POST",
            url: "removeLecture",
            data: { 
                hallId: hallId,
                timeSlot: timeSlot
            },
            success: function(response) {
                if (response === "success") {
                    const lectureOptions = lectures.map(lecture => `
                        <option value="${lecture.id}">${lecture.name} by ${lecture.professor}</option>
                    `).join('');

                    document.getElementById(`lecture_${hallId}_${timeSlot}`).innerHTML = `
                        <button class="btn btn-primary btn-sm"
                                onclick="showDropdown('${timeSlot}', ${hallId})">
                            Assign
                        </button>
                        <div id="dropdown_${hallId}_${timeSlot}" style="display: none;">
                            <select id="lectureSelect_${hallId}_${timeSlot}">
                                ${lectureOptions}
                            </select>
                            <button class="btn btn-success btn-sm"
                                    onclick="assignLecture('${timeSlot}', ${hallId})">
                                ✔️
                            </button>
                        </div>
                    `;
                }
            }
        });
    }
}




function showStudentModal(hallId, capacity, timeSlot) {
    currentHallId = hallId;
    currentCapacity = capacity;
    currentTimeSlot = timeSlot;
    $('#studentAssignmentModal').modal('show');
    loadStudents(hallId, timeSlot);
}

function loadStudents(hallId, timeSlot) {
    $.ajax({
        url: 'getStudents',
        data: { 
            hallId: hallId,
            timeSlot: timeSlot
        },
        success: function(response) {
            renderStudents(response.available, response.assigned);
            updateCapacityAlert(response.assigned.length);
        }
    });
}

function renderStudents(available, assigned) {
    const availableDiv = $('#availableStudents');
    const assignedDiv  = $('#assignedStudents');
    
    availableDiv.empty();
    assignedDiv.empty();

    available.forEach(student => {
        availableDiv.append(`
            <div class="student-item">
                <span>${student.name} (${student.username})</span>
                <button class="btn btn-success btn-sm" 
                        onclick="assignStudent(${student.id})">
                    Add ➕
                </button>
            </div>
        `);
    });

    assigned.forEach(student => {
        assignedDiv.append(`
            <div class="student-item">
                <span>${student.name} (${student.username})</span>
                <button class="btn btn-danger btn-sm" 
                        onclick="removeStudent(${student.id})">
                    Remove ➖
                </button>
            </div>
        `);
    });

    // After rendering, wire up the search filter:
    $('#studentSearch').off('input').on('input', function() {
        const term = this.value.toLowerCase();
        $('#availableStudents .student-item').each(function() {
            // match against the "(ID)" piece or full text
            const text = $(this).text().toLowerCase();
            $(this).toggle(text.includes(term));
        });
    });
}


function assignStudent(studentId) {
    $.ajax({
        url: 'assignStudent',
        method: 'POST',
        data: { 
            hallId: currentHallId,
            studentId: studentId,
            timeSlot: currentTimeSlot
        },
        success: function(response) {
            const parsedResponse = JSON.parse(response);
            loadStudents(currentHallId, currentTimeSlot);
            updateStudentCount(parsedResponse.newCount);
        }
    });
}

function removeStudent(studentId) {
    $.ajax({
        url: 'removeStudent',
        method: 'POST',
        data: { 
            hallId: currentHallId,
            studentId: studentId,
            timeSlot: currentTimeSlot
        },
        success: function(response) {
            const parsedResponse = JSON.parse(response);
            console.log(parsedResponse.newCount);
            loadStudents(currentHallId, currentTimeSlot);
            
            updateStudentCount(parsedResponse.newCount);
        }
    });
}

function updateStudentCount(count) {
    
    Promise.all([
        fetch('/ClassManagementSystem/lecture-halls-data').then(res => res.json()),

    ]).then(([hallsData, lecturesData]) => {
        console.log('Lecture Halls Data:', hallsData); 
        console.log('Lectures Data:', lecturesData);   
        lectureHalls = hallsData;

        updateLectureHallsTable(currentDay);
    }).catch(error => {
        console.error('Error fetching data:', error);
    });
    
    updateCapacityAlert(count);
}



function updateCapacityAlert(currentCount) {
    const alert = $('#capacityAlert');
    if (currentCount >= currentCapacity) {
        alert.show().text(`Capacity reached! (${currentCount}/${currentCapacity})`);
    } else {
        alert.hide();
    }
}