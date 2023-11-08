function generateWeekOptions(selectedYear) {
    const selectWeek = document.getElementById("week");
    const currentDate = new Date();
    while (selectWeek.firstChild) {
        selectWeek.removeChild(selectWeek.firstChild);
    }
    for (let week = 1; week <= 52; week++) {
        const option = document.createElement("option");
        option.value = week;
        const firstDayOfWeek = new Date(selectedYear, 0, (week - 1) * 7 + 1);
        while (firstDayOfWeek.getDay() !== 1) {
            firstDayOfWeek.setDate(firstDayOfWeek.getDate() + 1);
        }
        const lastDayOfWeek = new Date(firstDayOfWeek);
        lastDayOfWeek.setDate(lastDayOfWeek.getDate() + 6);
        const formattedFirstDay = formatDate(firstDayOfWeek);
        const formattedLastDay = formatDate(lastDayOfWeek);
        option.text = `${formattedFirstDay} - ${formattedLastDay}`;
        if (week == getWeekNumber(currentDate)) {
            option.selected = true;
        }
        selectWeek.appendChild(option);
    }
}

function formatDate(date) {
    const day = date.getDate();
    const month = date.getMonth() + 1;
    return `${day.toString().padStart(2, "0")}/${month.toString().padStart(2, "0")}`;
}

function getWeekNumber(date) {
    const currentDate = new Date(date);
    currentDate.setHours(0, 0, 0, 0);
    currentDate.setDate(currentDate.getDate() + 3 - (currentDate.getDay() + 6) % 7);
    const startOfYear = new Date(currentDate.getFullYear(), 0, 1);
    const weekNumber = Math.ceil(((currentDate - startOfYear) / 86400000 + 1) / 7);
    return weekNumber;
}

const selectYear = document.getElementById("year");
const selectWeek = document.getElementById("week");
selectYear.addEventListener("change", function () {
    const selectedYear = parseInt(selectYear.value);
    generateWeekOptions(selectedYear);
    updateDays(selectedYear, parseInt(selectWeek.value));
});
selectWeek.addEventListener("change", function () {
    const selectedYear = parseInt(selectYear.value);
    const selectedWeek = parseInt(selectWeek.value);
    updateDays(selectedYear, selectedWeek);
});

function updateDays(year, week) {
    const startOfWeek = new Date(year, 0, 1);
    while (startOfWeek.getDay() !== 1) {
        startOfWeek.setDate(startOfWeek.getDate() + 1);
    }
    startOfWeek.setDate(startOfWeek.getDate() + (week - 1) * 7);
    const days = document.querySelectorAll(".day");
    for (let i = 0; i < 7; i++) {
        days[i].textContent = formatDate(startOfWeek);
        startOfWeek.setDate(startOfWeek.getDate() + 1);
    }
}

generateWeekOptions(parseInt(selectYear.value));
updateDays(parseInt(selectYear.value), parseInt(selectWeek.value));
showLession()

function convertTime(time) {
    var parts = time.split(" - ");

    if (parts.length === 2) {
        var startTime = parts[0];
        var endTime = parts[1];
        var formattedString = startTime.substring(0, 5) + " - " + endTime.substring(0, 5);
        return formattedString;
    }
}
var icode = document.querySelector('#search-bar').value;

function showLession() {

    var url = `http://localhost:8080/attendance_system_war/api/teacher/report/schedule-of-week/${icode}`;
    fetch(url)
        .then(response => response.json())
        .then(data => {
            var days = document.querySelectorAll('.day');
            var year = document.querySelector('#year').value;
            days.forEach(day => {
                var dateCalender = day.textContent + '/' + year;
                var dateAfterConverted = changeDateFormat(dateCalender);
                data.forEach(dat => {
                    var lessonID = dat["lessonID"];
                    var groupName = dat["groupname"];
                    var courseName = dat["courseName"];
                    var roomName = dat["roomName"];
                    var timeSlot = dat["timeSlot"];
                    var date = dat["date"];
                    var timeLast = convertTime(dat["timeLast"]);
                    var attendanceStatus = dat["attendanceStatus"]
                    var dayOfWeek = new Date(date).getDay();
                    var slot = parseInt(timeSlot);
                    switch (slot) {
                        case 6:
                            slot = 1;
                            break;
                        case 7:
                            slot = 2;
                            break;
                        case 8:
                            slot = 3;
                            break;
                        case 9:
                            slot = 4;
                            break;
                        case 10:
                            slot = 5;
                            break;
                        case 11:
                            slot = 6;
                            break;
                        case 12:
                            slot = 7;
                            break;
                    }

                    if (true) {
                        switch (dayOfWeek) {
                            case 0:
                                var add = '#slot' + `${slot}` + ' .sun';
                                var lessonSlot = document.querySelector(`${add}`);
                                var status = '';
                                if (attendanceStatus == true) {
                                    status = 'bubble-present';
                                } else {
                                    status = 'bubble-absent';
                                }
                                lessonSlot.innerHTML = ` <div class="lesson" onclick="showLessonDetail(${lessonID})">
                                                         <span class="group">${groupName}</span><br><span class="course">${courseName}</span>
                                                         <span class="room">${roomName}</span><br><br>
                                                         <span class="material-symbols-outlined" id="clock">
                                                         schedule
                                                         </span>
                                                         <span class="time">${timeLast}</span>
                                                         <span class="${status}"></span>
                                                         </div>`;
                                break;

                            case 1:
                                var add = '#slot' + `${slot}` + ' .mon';
                                var lessonSlot = document.querySelector(`${add}`)
                                var status = '';
                                if (attendanceStatus == true) {
                                    status = 'bubble-present';
                                } else {
                                    status = 'bubble-absent';
                                }
                                lessonSlot.innerHTML = ` <div class="lesson" onclick="showLessonDetail(${lessonID})">
                                                   <span class="group">${groupName}</span><br><span class="course">${courseName}</span>
                                                   <span class="room">${roomName}</span><br><br>
                                                   <span class="material-symbols-outlined" id="clock">
                                                   schedule
                                                   </span>
                                                   <span class="time">${timeLast}</span>
                                                   <span class="${status}"></span>
                                                   </div>`;
                                break;

                            case 2:
                                var add = '#slot' + `${slot}` + ' .tue';
                                var lessonSlot = document.querySelector(`${add}`)
                                var status = '';
                                if (attendanceStatus == true) {
                                    status = 'bubble-present';
                                } else {
                                    status = 'bubble-absent';
                                }
                                lessonSlot.innerHTML = ` <div class="lesson" onclick="showLessonDetail(${lessonID})">
                                                            <span class="group">${groupName}</span><br><span class="course">${courseName}</span>
                                                            <span class="room">${roomName}</span><br><br>
                                                            <span class="material-symbols-outlined" id="clock">
                                                            schedule
                                                            </span>
                                                            <span class="time">${timeLast}</span>
                                                            <span class="${status}"></span>
                                                            </div>`;
                                break;

                            case 3:
                                var add = '#slot' + `${slot}` + ' .wed';
                                var lessonSlot = document.querySelector(`${add}`)
                                var status = '';
                                if (attendanceStatus == true) {
                                    status = 'bubble-present';
                                } else {
                                    status = 'bubble-absent';
                                }
                                lessonSlot.innerHTML = ` <div class="lesson" onclick="showLessonDetail(${lessonID})">
                                                   <span class="group">${groupName}</span><br><span class="course">${courseName}</span>
                                                   <span class="room">${roomName}</span><br><br>
                                                   <span class="material-symbols-outlined" id="clock">
                                                   schedule
                                                   </span>
                                                   <span class="time">${timeLast}</span>
                                                   <span class="${status}"></span>
                                                   </div>`;
                                break;

                            case 4:
                                var add = '#slot' + `${slot}` + ' .thu';
                                var lessonSlot = document.querySelector(`${add}`)
                                var status = '';
                                if (attendanceStatus == true) {
                                    status = 'bubble-present';
                                } else {
                                    status = 'bubble-absent';
                                }
                                lessonSlot.innerHTML = ` <div class="lesson" onclick="showLessonDetail(${lessonID})">
                                                   <span class="group">${groupName}</span><br><span class="course">${courseName}</span>
                                                   <span class="room">${roomName}</span><br><br>
                                                   <span class="material-symbols-outlined" id="clock">
                                                   schedule
                                                   </span>
                                                   <span class="time">${timeLast}</span>
                                                   <span class="${status}"></span>
                                                   </div>`;
                                break;
                            case 5:
                                var add = '#slot' + `${slot}` + ' .fri';
                                var lessonSlot = document.querySelector(`${add}`)
                                var status = '';
                                if (attendanceStatus == true) {
                                    status = 'bubble-present';
                                } else {
                                    status = 'bubble-absent';
                                }
                                lessonSlot.innerHTML = `<div class="lesson" onclick="showLessonDetail(${lessonID})">
                                                   <span class="group">${groupName}</span><br><span class="course">${courseName}</span>
                                                   <span class="room">${roomName}</span><br><br>
                                                   <span class="material-symbols-outlined" id="clock">
                                                   schedule
                                                   </span>
                                                   <span class="time">${timeLast}</span>
                                                   <span class="${status}"></span>
                                                   </div>`;
                                break;
                            case 6:
                                var add = '#slot' + `${slot}` + ' .sat';
                                var lessonSlot = document.querySelector(`${add}`)
                                var status = '';
                                if (attendanceStatus == true) {
                                    status = 'bubble-present';
                                } else {
                                    status = 'bubble-absent';
                                }
                                lessonSlot.innerHTML = ` <div class="lesson" onclick="showLessonDetail(${lessonID})">
                                                   <span class="group">${groupName}</span><br><span class="course">${courseName}</span>
                                                   <span class="room">${roomName}</span><br><br>
                                                   <span class="material-symbols-outlined" id="clock">
                                                   schedule
                                                   </span>
                                                   <span class="time">${timeLast}</span>
                                                   <span class="${status}"></span>
                                                   </div>`;
                                break;
                        }
                    }
                });
            });
        })
        .catch(error => {
            console.error('Lỗi: ', error);
        });
}


function changeDateFormat(inputDate) {
    const dateParts = inputDate.split('/');
    const day = dateParts[0];
    const month = dateParts[1];
    const year = dateParts[2];
    const newDateFormat = `${year}-${month}-${day}`;
    return newDateFormat;
}

function showLessonDetail(lessonID) {
    var urlAPI = `http://localhost:8080/attendance_system_war/api/teacher/report/lesson/${lessonID}`;
    fetch(urlAPI)
        .then(response => response.json())
        .then(data => {
            var lessonDate = new Date(data["date"]);
            var status = data["attendanceStatus"];
            var currentDate = new Date();
            if (!status) {
                if (currentDate < lessonDate) {
                    var url = "teacher/addEvent?lessonId=" + lessonID;
                    window.location.href = url;

                } else {
                    var url = "teacher/attendance?lessonId=" + lessonID;
                    window.location.href = url;

                }
            } else {
                if (currentDate > lessonDate) {
                    alert("The period for changing attendance is over.");
                }
                if(currentDate === lessonDate) {
                    var url = "teacher/attendance?lessonId=" + lessonID;
                    window.location.href = url;
                }
            }

        });


}

updateTimeTable();

function updateTimeTable() {
    var slots = document.querySelectorAll('.slot');
    slots.forEach(slot => {
        slot.innerHTML = `<td class="mon">-</td>
      <td class="tue">-</td>
      <td class="wed">-</td>
      <td class="thu">-</td>
      <td class="fri">-</td>
      <td class="sat">-</td>
      <td class="sun">-</td>`;
    });
    var dateAfterChange = document.querySelector('#week');
    var yearAterChange = document.querySelector('#year');
    var monday = getMonday(dateAfterChange.value, yearAterChange.value);
    showLessionAterChange(monday)
}

function getMonday(n, x) {
    const firstDayOfYear = new Date(x, 0, 1);
    const firstWeekDay = firstDayOfYear.getDay();
    const daysToAdd = (n - 1) * 7 - firstWeekDay + 1;
    const mondayOfWeekN = new Date(x, 0, daysToAdd + 1);

    // Chuyển đổi ngày thành chuỗi theo định dạng 'yyyy-mm-dd'
    const year = mondayOfWeekN.getFullYear();
    const month = String(mondayOfWeekN.getMonth() + 1).padStart(2, '0');
    const day = String(mondayOfWeekN.getDate()).padStart(2, '0');
    const formattedDate = `${year}-${month}-${day}`;

    return formattedDate;
}

function showLessionAterChange(date) {
    var url = `http://localhost:8080/attendance_system_war/api/teacher/report/schedule-of-week/${icode}/` + `${date}`;
    fetch(url)
        .then(response => response.json())
        .then(data => {
            var days = document.querySelectorAll('.day');
            var year = document.querySelector('#year').value;
            days.forEach(day => {
                var dateCalender = day.textContent + '/' + year;
                var dateAfterConverted = changeDateFormat(dateCalender);
                data.forEach(dat => {
                    var lessonID = dat["lessonID"];
                    var groupName = dat["groupname"];
                    var courseName = dat["courseName"];
                    var roomName = dat["roomName"];
                    var timeSlot = dat["timeSlot"];
                    var date = dat["date"];
                    var timeLast = convertTime(dat["timeLast"]);
                    var attendanceStatus = dat["attendanceStatus"]
                    var dayOfWeek = new Date(date).getDay();
                    var slot = parseInt(timeSlot);
                    switch (slot) {
                        case 6:
                            slot = 1;
                            break;
                        case 7:
                            slot = 2;
                            break;
                        case 8:
                            slot = 3;
                            break;
                        case 9:
                            slot = 4;
                            break;
                        case 10:
                            slot = 5;
                            break;
                        case 11:
                            slot = 6;
                            break;
                        case 12:
                            slot = 7;
                            break;
                    }
                    if (true) {
                        switch (dayOfWeek) {
                            case 0:
                                var add = '#slot' + `${slot}` + ' .sun';
                                var lessonSlot = document.querySelector(`${add}`);
                                var status = '';
                                if (attendanceStatus == true) {
                                    status = 'bubble-present';
                                } else {
                                    status = 'bubble-absent';
                                }
                                lessonSlot.innerHTML = ` <div class="lesson" onclick="showLessonDetail(${lessonID})">
                                                         <span class="group">${groupName}</span><br><span class="course">${courseName}</span>
                                                         <span class="room">${roomName}</span><br><br>
                                                         <span class="material-symbols-outlined" id="clock">
                                                         schedule
                                                         </span>
                                                         <span class="time">${timeLast}</span>
                                                         <span class="${status}"></span>
                                                         </div>`;
                                break;

                            case 1:
                                var add = '#slot' + `${slot}` + ' .mon';
                                var lessonSlot = document.querySelector(`${add}`)
                                var status = '';
                                if (attendanceStatus == true) {
                                    status = 'bubble-present';
                                } else {
                                    status = 'bubble-absent';
                                }
                                lessonSlot.innerHTML = ` <div class="lesson" onclick="showLessonDetail(${lessonID})">
                                                   <span class="group">${groupName}</span><br><span class="course">${courseName}</span>
                                                   <span class="room">${roomName}</span><br><br>
                                                   <span class="material-symbols-outlined" id="clock">
                                                   schedule
                                                   </span>
                                                   <span class="time">${timeLast}</span>
                                                   <span class="${status}"></span>
                                                   </div>`;
                                break;

                            case 2:
                                var add = '#slot' + `${slot}` + ' .tue';
                                var lessonSlot = document.querySelector(`${add}`)
                                var status = '';
                                if (attendanceStatus == true) {
                                    status = 'bubble-present';
                                } else {
                                    status = 'bubble-absent';
                                }
                                lessonSlot.innerHTML = ` <div class="lesson" onclick="showLessonDetail(${lessonID})">
                                                            <span class="group">${groupName}</span><br><span class="course">${courseName}</span>
                                                            <span class="room">${roomName}</span><br><br>
                                                            <span class="material-symbols-outlined" id="clock">
                                                            schedule
                                                            </span>
                                                            <span class="time">${timeLast}</span>
                                                            <span class="${status}"></span>
                                                            </div>`;
                                break;

                            case 3:
                                var add = '#slot' + `${slot}` + ' .wed';
                                var lessonSlot = document.querySelector(`${add}`)
                                var status = '';
                                if (attendanceStatus == true) {
                                    status = 'bubble-present';
                                } else {
                                    status = 'bubble-absent';
                                }
                                lessonSlot.innerHTML = ` <div class="lesson" onclick="showLessonDetail(${lessonID})">
                                                   <span class="group">${groupName}</span><br><span class="course">${courseName}</span>
                                                   <span class="room">${roomName}</span><br><br>
                                                   <span class="material-symbols-outlined" id="clock">
                                                   schedule
                                                   </span>
                                                   <span class="time">${timeLast}</span>
                                                   <span class="${status}"></span>
                                                   </div>`;
                                break;

                            case 4:
                                var add = '#slot' + `${slot}` + ' .thu';
                                var lessonSlot = document.querySelector(`${add}`)
                                var status = '';
                                if (attendanceStatus == true) {
                                    status = 'bubble-present';
                                } else {
                                    status = 'bubble-absent';
                                }
                                lessonSlot.innerHTML = ` <div class="lesson" onclick="showLessonDetail(${lessonID})">
                                                   <span class="group">${groupName}</span><br><span class="course">${courseName}</span>
                                                   <span class="room">${roomName}</span><br><br>
                                                   <span class="material-symbols-outlined" id="clock">
                                                   schedule
                                                   </span>
                                                   <span class="time">${timeLast}</span>
                                                   <span class="${status}"></span>
                                                   </div>`;
                                break;
                            case 5:
                                var add = '#slot' + `${slot}` + ' .fri';
                                var lessonSlot = document.querySelector(`${add}`)
                                var status = '';
                                if (attendanceStatus == true) {
                                    status = 'bubble-present';
                                } else {
                                    status = 'bubble-absent';
                                }
                                lessonSlot.innerHTML = `<div class="lesson" onclick="showLessonDetail(${lessonID})">
                                                   <span class="group">${groupName}</span><br><span class="course">${courseName}</span>
                                                   <span class="room">${roomName}</span><br><br>
                                                   <span class="material-symbols-outlined" id="clock">
                                                   schedule
                                                   </span>
                                                   <span class="time">${timeLast}</span>
                                                   <span class="${status}"></span>
                                                   </div>`;
                                break;
                            case 6:
                                var add = '#slot' + `${slot}` + ' .sat';
                                var lessonSlot = document.querySelector(`${add}`)
                                var status = '';
                                if (attendanceStatus == true) {
                                    status = 'bubble-present';
                                } else {
                                    status = 'bubble-absent';
                                }
                                lessonSlot.innerHTML = ` <div class="lesson" onclick="showLessonDetail(${lessonID})">
                                                   <span class="group">${groupName}</span><br><span class="course">${courseName}</span>
                                                   <span class="room">${roomName}</span><br><br>
                                                   <span class="material-symbols-outlined" id="clock">
                                                   schedule
                                                   </span>
                                                   <span class="time">${timeLast}</span>
                                                   <span class="${status}"></span>
                                                   </div>`;
                                break;
                        }
                    }
                });
            });
        })
        .catch(error => {
            console.error('Lỗi: ', error);
        });
}