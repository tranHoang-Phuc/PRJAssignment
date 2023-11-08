var lessonId = document.querySelector('#lessonId').value;
var url = `http://localhost:8080/attendance_system_war/api/teacher/report/lesson/${lessonId}`;
var lessonInfo = document.querySelector('#lesson-info');
var eventContent = document.querySelector('#event');
fetch(url)
    .then(response => response.json())
    .then(data => {
        var group = data["groupname"];
        var course = data["courseName"];
        var sesionNo = data["sessionNo"];
        var date = conver(new Date(data["date"]));
        var time = data["timeLast"];
        var room= data["roomName"];
        var event = data["event"];
        lessonInfo.innerHTML = `
            <p>Course: <b>${course}</b></p>
            <p>Class: <b>${group}</b></p>
            <p>Time: ${time}</p>
            <p>Session-no: ${sesionNo}</p>
            <p>Date: ${date}</p>
            <p>Room: ${room}</p>`;
        eventContent.value = event;
    });

function conver(mondayOfWeekN) {
    const year = mondayOfWeekN.getFullYear();
    const month = String(mondayOfWeekN.getMonth() + 1).padStart(2, '0');
    const day = String(mondayOfWeekN.getDate()).padStart(2, '0');
    const formattedDate = `${day}-${month}-${year}`;
    return formattedDate;
}