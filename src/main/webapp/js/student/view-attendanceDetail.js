const elements = document.querySelectorAll('.element-semester');
showOn(elements);
const elementCourse = document.querySelectorAll('.element-course');
showOn(elementCourse);
const elementGroup = document.querySelectorAll('.element-group');
showOn(elementGroup);

function getAbsentRate() {
    const absentElements = document.querySelectorAll('.attendanceStatus');
    let absentCount = 0;

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

var sid = document.querySelector('#sid').value;
var group = document.querySelector('#group').textContent;
var course = document.querySelector('#course').textContent;
var url = `http://localhost:8080/attendance_system_war/api/teacher/report/attendance/${sid}/${group}/${course}`;
var index = 1;
var tbody = document.querySelector('#data');
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
            if (slot >6) {
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
        absentRate.innerHTML = '<span><b>' + getAbsentRate() + '</b></span>' + absentRate.innerHTML;
    });
function remind(sid) {
    var url = `http://localhost:8080/attendance_system_war/teacher/sendMail?sid=${sid}`;
    window.location.href = url;
}