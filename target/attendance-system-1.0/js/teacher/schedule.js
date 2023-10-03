
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

function showLession() {
    var jsonString = '[{"lesson-id": "1","group": "SE1763","instructor": "sonnt5","course": "PRJ301","room": "BE-202","session-no": "1","slot-id": "4","attend-status": "true","date": "2023-10-02"}, {"lesson-id": "1","group": "IA1708","instructor": "dungltk","course": "JPD123","room": "BE-410","session-no": "1","slot-id": "1","attend-status": "false","date": "2023-10-03"}, {"lesson-id": "1","group": "AI1805","instructor": "chungttk","course": "MAS291","room": "BE-310","session-no": "1","slot-id": "2","attend-status": "false","date": "2023-10-03"}]';
    var lessonArray = JSON.parse(jsonString);
    var days = document.querySelectorAll('.day');
    var year = document.querySelector('#year').value;
    console.log(year);
    days.forEach(day => {
        var dateCalender = day.textContent + '/' + year;
        var dateAfterConverted = changeDateFormat(dateCalender);
        lessonArray.forEach(lesson => {
            var lessonID = lesson["lesson-id"];
            var group = lesson["group"];
            var instructor = lesson["instructor"];
            var course = lesson["course"];
            var room = lesson["room"];
            var sessionNo = lesson["session-no"];
            var slotID = lesson["slot-id"];
            var attendStatus = lesson["attend-status"];
            var date = new Date(lesson["date"]);

            if (dateAfterConverted == lesson["date"]) {
                var dayOfWeek = date.getDay();
                switch (dayOfWeek) {
                    case 0:
                        var add = '#slot' + `${slotID}` + ' .sun';
                        var lessonSlot = document.querySelector(`${add}`);
                        if (attendStatus == 'true') {
                            console.log('haha')
                        }
                        lessonSlot.innerHTML = ` <div class="lesson">
                                                <span>${course}</span>
                                                <span class="room">${room}</span><br><br>
                                                <span class="material-symbols-outlined" id="clock">
                                                schedule
                                                </span>
                                                <span class="time">15:20 - 17h40</span>
                                                <span class="bubble-absent"></span>
                                                </div>`;
                        break;
                    case 1:
                        var add = '#slot' + `${slotID}` + ' .mon';
                        var lessonSlot = document.querySelector(`${add}`)
                        var status = '';
                        if (attendStatus == 'true') {
                            status = 'bubble-present';
                        } else {
                            status = 'bubble-absent';
                        }
                        lessonSlot.innerHTML = ` <div class="lesson">
                                                <span>${course}</span>
                                                <span class="room">${room}</span><br><br>
                                                <span class="material-symbols-outlined" id="clock">
                                                schedule
                                                </span>
                                                <span class="time">15:20 - 17h40</span>
                                                <span class="${status}"></span>
                                                </div>`;
                        break;
                    case 2:
                        var add = '#slot' + `${slotID}` + ' .tue';
                        var lessonSlot = document.querySelector(`${add}`)
                        var status = '';
                        if (attendStatus == 'true') {
                            status = 'bubble-present';
                        } else {
                            status = 'bubble-absent';
                        }
                        lessonSlot.innerHTML = ` <div class="lesson">
                                                <span>${course}</span>
                                                <span class="room">${room}</span><br><br>
                                                <span class="material-symbols-outlined" id="clock">
                                                schedule
                                                </span>
                                                <span class="time">15:20 - 17h40</span>
                                                <span class="${status}"></span>
                                                </div>`;
                        break;
                    case 3:
                        var add = '#slot' + `${slotID}` + ' .wed';
                        var lessonSlot = document.querySelector(`${add}`)
                        var status = '';
                        if (attendStatus == 'true') {
                            status = 'bubble-present';
                        } else {
                            status = 'bubble-absent';
                        }
                        lessonSlot.innerHTML = ` <div class="lesson">
                                                <span>${course}</span>
                                                <span class="room">${room}</span><br><br>
                                                <span class="material-symbols-outlined" id="clock">
                                                schedule
                                                </span>
                                                <span class="time">15:20 - 17h40</span>
                                                <span class="${status}"></span>
                                                </div>`;
                        break;
                    case 4:
                        var add = '#slot' + `${slotID}` + ' .thu';
                        var lessonSlot = document.querySelector(`${add}`)
                        var status = '';
                        if (attendStatus == 'true') {
                            status = 'bubble-present';
                        } else {
                            status = 'bubble-absent';
                        }
                        lessonSlot.innerHTML = ` <div class="lesson">
                                                <span>${course}</span>
                                                <span class="room">${room}</span><br><br>
                                                <span class="material-symbols-outlined" id="clock">
                                                schedule
                                                </span>
                                                <span class="time">15:20 - 17h40</span>
                                                <span class="${status}"></span>
                                                </div>`;
                        break;
                    case 5:
                        var add = '#slot' + `${slotID}` + ' .fri';
                        var lessonSlot = document.querySelector(`${add}`)
                        var status = '';
                        if (attendStatus == 'true') {
                            status = 'bubble-present';
                        } else {
                            status = 'bubble-absent';
                        }
                        lessonSlot.innerHTML = ` <div class="lesson">
                                                <span>${course}</span>
                                                <span class="room">${room}</span><br><br>
                                                <span class="material-symbols-outlined" id="clock">
                                                schedule
                                                </span>
                                                <span class="time">15:20 - 17h40</span>
                                                <span class="${status}"></span>
                                                </div>`;
                    case 6:
                        var add = '#slot' + `${slotID}` + ' .sat';
                        var lessonSlot = document.querySelector(`${add}`)
                        var status = '';
                        if (attendStatus == 'true') {
                            status = 'bubble-present';
                        } else {
                            status = 'bubble-absent';
                        }
                        lessonSlot.innerHTML = ` <div class="lesson">
                                                <span>${course}</span>
                                                <span class="room">${room}</span><br><br>
                                                <span class="material-symbols-outlined" id="clock">
                                                schedule
                                                </span>
                                                <span class="time">15:20 - 17h40</span>
                                                <span class="${status}"></span>
                                                </div>`;
                        break;
                }
            }
        });
    });

}

function changeDateFormat(inputDate) {
    // Split the inputDate by "/" to get day, month, and year
    const dateParts = inputDate.split('/');

    // Ensure that we have exactly three parts (dd, mm, yyyy)
    if (dateParts.length !== 3) {
        return "Invalid date format";
    }
    const day = dateParts[0];
    const month = dateParts[1];
    const year = dateParts[2];
    const newDateFormat = `${year}-${month}-${day}`;
    return newDateFormat;
}
