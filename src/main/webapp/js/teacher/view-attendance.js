const elementCourse = document.querySelectorAll('.element-course');
showOn(elementCourse);

function showOn(elements) {
    elements.forEach(element => {
        element.addEventListener('click', () => {
            elements.forEach(e => e.classList.remove('selected'));
            element.classList.add('selected');
        });
    });
}


displaySemester();

function show(element) {
    const course = document.querySelector('#course');
    const elements = document.querySelectorAll('.element-semester');
    elements.forEach(e => e.classList.remove('selected'));
    element.classList.add('selected');
    var semesterName = document.querySelector('#semester .selected').textContent;
    var courseNameUrl = `http://localhost:8080/attendance_system_war/api/university/course/${semesterName}`;
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
    const semester = document.querySelector('#semester .selected').textContent;
    const courseName = course.textContent;
    const elements = document.querySelectorAll('.element-course');
    elements.forEach(e => e.classList.remove('selected'));
    course.classList.add('selected');
    const classUrl = `http://localhost:8080/attendance_system_war/api/university/student/${semester}/${courseName}`;
    var groupZone = document.querySelector('#group');
    groupZone.innerHTML = '';
    fetch(classUrl)
        .then(response => response.json())
        .then(data => {
            data.forEach(dat => {
                var groupName = dat["groupName"];
                groupZone.innerHTML += `<div class="element-group" onclick="showAttendance(this)">${groupName}</div>`
            });
        });
}

function showAttendance(group) {
    const studentData = document.querySelector('#studentData');
    studentData.innerHTML = '';
    const elements = document.querySelectorAll('.element-group');
    elements.forEach(e => e.classList.remove('selected'));
    group.classList.add('selected');
    const semester = document.querySelector('#semester .selected').textContent;
    const course = document.querySelector('#course .selected').textContent;
    const groupName = group.textContent;
    var attendanceUrl = `http://localhost:8080/attendance_system_war/api/university/student/${semester}/${course}/${groupName}`;
    var no = 0;
    fetch(attendanceUrl)
        .then(response => response.json())
        .then(data => {
            data.forEach(dat => {
                var colorStatus = '';
                var absentPersent = 0;
                var absentCount = 0;
                no++;
                var sid = dat["studentDTO"]["sid"];
                var studentName = dat["studentDTO"]["firstName"] + ' ' + dat["studentDTO"]["lastName"];
                var sCode = dat["studentDTO"]["scode"];
                var group = dat["attendanceDTOS"][0]["groupName"];
                var attendanceData = dat["attendanceDTOS"];
                var row = document.createElement('tr');
                row.setAttribute('onclick', `getDetail('${sid}', '${groupName}', '${course}')`);

                row.classList.add(`student${no}`);
                row.innerHTML = ` <td>${no}</td>
                              <td>${studentName}</td>
                              <td>${sCode}</td>
                              <td>${group}</td>`;
                attendanceData.forEach(a => {

                    var statusLabel = '';
                    var status = a["status"];
                    if (status === 1) {
                        statusLabel = `<span class="material-symbols-outlined present" style="color:green;">
                                 check_small
                              </span>`;
                    } else if (status === 0) {
                        absentCount++;
                        statusLabel = `<span class="material-symbols-outlined absent" style="color:red;">
                                 close
                              </span>`;
                    } else {
                        statusLabel = `<span class="material-symbols-outlined future" style="color:orange;">
                                 circle
                              </span>`;
                    }
                    row.innerHTML += `<td>${statusLabel}</td>`;
                    absentPersent = (absentCount / attendanceData.length) * 100;


                });
                if (absentPersent > 20) {
                    colorStatus = "rgba(255, 0, 0, 0.5)"
                } else if (absentPersent > 10 && absentPersent <= 20) {
                    colorStatus = "rgba(255,215,0, 0.5)";
                } else {
                    colorStatus ="rgba(255,255,255, 0.5)";
                }
                row.innerHTML += `<td class="persent" style="background-color: ${colorStatus};">${absentPersent.toFixed(0)}%</td>`
                studentData.appendChild(row);
            });

        });

    document.querySelector('.wrap').style.display = 'block';

}


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

function getDetail(sid, group, course) {
    var url = `http://localhost:8080/attendance_system_war/teacher/attendance-detail?sid=${sid}&group=${group}&course=${course}`;
    window.location.href = url;
}

