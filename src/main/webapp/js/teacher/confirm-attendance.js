var lecture = document.querySelector('#lecture').textContent;
var lessonId = document.querySelector('#lessonId').value;
var url = 'http://localhost:8080/attendance_system_war/api/teacher/report/attendance/' + lessonId;
var students = document.querySelector('#students');
var no = 1;
fetch(url)
    .then(response => response.json())
    .then(data => {
        data.forEach(dat => {
            var sid = dat["student"]["sid"];
            var group = dat["lesson"]["groupname"];
            var scode = dat["student"]["scode"];
            var course = dat["lesson"]["courseName"];
            var name = dat["student"]["firstName"] + " "+ dat["student"]["lastName"];
            var img = dat["student"]["img"];
            var status = dat["status"];
            var comment = dat["comment"] === null ? '' : dat["comment"];
            var date = new Date(dat["recordedDay"]);
            const year = date.getFullYear();
            const month = date.getMonth() + 1;
            const day = date.getDate();
            var attendanceDate = `${day}/${month}/${year}`;
            var time = dat["recordedTime"];
            var statusAttendance = '';
            var color = '';
            if (status == 0) {
                statusAttendance = 'Absent';
                color = 'red';
            }
            if (status == 1) {
                statusAttendance = 'Present';
                color = 'green';
            }
            students.innerHTML += `<tr>
                                       <td>${no}</td>
                                       <td>${group}</td>
                                       <td>${scode}</td>
                                       <td>${name}</td>
                                       <td><img src="${img}" alt=""></td>
                                       <td style="color: ${color};">
                                          <b style="color: ${color};">
                                             ${statusAttendance}</b>                                         
                                       </td>
                                       <td>${comment}</td>
                                       <td>${lecture}</td>
                                       <form action="#" method="GET">
                                          <input type="hidden" value="${scode}">
                                          <input type="hidden" value="${group}">
                                          <input type="hidden" value="">
                                       <td><span><button type="button" class="btn btn-outline-primary" onclick="viewAttendance('${sid}', '${group}', '${course}')">View detail</a></button></span></td>
                                       </form>
                                 </tr>`;
            no++;
        });
    });

function viewAttendance(sid, group, course) {
    const url = `http://localhost:8080/attendance_system_war/teacher/attendance-detail?sid=${sid}&group=${group}&course=${course}`;
    window.location.href = url;
}

function save() {
    const url = `http://localhost:8080/attendance_system_war/weeklySchedule`;
    window.location.href = url;
}
function edit(lessonId) {
    const url = `http://localhost:8080/attendance_system_war/teacher/attendance?lessonId=${lessonId}`;
    window.location.href = url;
}