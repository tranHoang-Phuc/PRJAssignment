

function getAbsentRate() {
    const absentElements = document.querySelectorAll('.attendanceStatus');
    var absentCount = 0;

    absentElements.forEach(element => {
        if (element.textContent === 'Absent') {
            absentCount++;
        }
    });

    const totalElements = absentElements.length;
    const rate = (absentCount / totalElements) * 100;

    return `ABSENT: ${rate.toFixed(0)}% ABSENT SO FAR(${absentCount} ABSENT ON ${absentElements.length} TOTAL).`;
}


function showOn(elements) {
    elements.forEach(element => {
        element.addEventListener('click', () => {
            elements.forEach(e => e.classList.remove('selected'));
            element.classList.add('selected');
        });
    });
}




displaySemester();

function displaySemester() {
    const semesterZone = document.querySelector('#semester');

    const semesterUrl = `http://localhost:8080/attendance_system_war/api/university/semester`;
    fetch(semesterUrl)
        .then(response => response.json())
        .then(data => {
            data.forEach(dat => {
                const semesterName = dat["semesterName"];
                semesterZone.innerHTML += `<div class="element-semester" onclick="show(this)">${semesterName}</div>`;
            });
        });
}

function show(element) {
    const course = document.querySelector('#course');
    const elements = document.querySelectorAll('.element-semester');
    elements.forEach(e => e.classList.remove('selected'));
    element.classList.add('selected');
    var semesterName = document.querySelector('#semester .selected').textContent;
    var sid = document.querySelector('#sid').value;
    var courseNameUrl = `http://localhost:8080/attendance_system_war/api/student/report/list-course/${semesterName}/${sid}`;
    fetch(courseNameUrl)
        .then(response => response.json())
        .then(data => {
            course.innerHTML = '';
            data.forEach(dat => {
                const courseName = dat["courseName"];
                course.innerHTML += `<div class="element-course" onclick="showGroup(this)">${courseName}</div>`;
            });
        });
}

function showGroup(course) {
    var index = 1;
    document.querySelector('.wrap').style.display = 'block';
    const elements = document.querySelectorAll('.element-course');
    elements.forEach(e => e.classList.remove('selected'));
    course.classList.add('selected');
    const semester = document.querySelector('#semester .selected').textContent;
    const courseName = course.textContent;
    var sid = document.querySelector('#sid').value;
    var url = `http://localhost:8080/attendance_system_war/api/student/report/attendance/${semester}/${courseName}/${sid}`;
    var tbody = document.querySelector('#data');
    tbody.innerHTML = '';
    index = 1;

    fetch(url)
        .then(response => response.json())
        .then(data => {
            data.forEach(element => {
                var date = new Date(element["lesson"]["date"]);
                const year = date.getFullYear();
                const month = date.getMonth() + 1;
                const day = date.getDate();
                var attendanceDate = `${day}/${month}/${year}`;
                var slot = element["slotId"];
                var room = element["roomName"].trim();
                var lecture = element["lesson"]["instructorCode"];
                var group = element["groupName"];
                var attendance = element["status"];
                var color = '';
                var status = '';
                if (attendance === 0) {
                    status = 'Absent';
                    color = 'red';
                } else if (attendance === 1) {
                    status = 'Present';
                    color = 'green';
                } else {
                    status = 'Future';
                    color = 'orange';
                }
                if (slot > 6) {
                    slot = slot - 6;
                }
                tbody.innerHTML += `  <tr>
                                 <td>${index}</td>
                                 <td>${attendanceDate}</td>
                                 <td>${slot}</td>
                                 <td>${room}</td>
                                 <td>${lecture}</td>
                                 <td>${group}</td>
                                 <td style="color: ${color};" class="attendanceStatus">${status}</td>
                              </tr>`;
                index++;
            });
            var absentRate = document.querySelector('#absent-rate');
            absentRate.innerHTML = '';
            absentRate.innerHTML = '<span><b>' + getAbsentRate() + '</b></span>' + absentRate.innerHTML;
        });

}


