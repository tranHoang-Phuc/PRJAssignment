/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


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
    var postAPI =
            'https://jsonplaceholder.typicode.com/users';
    fetch(postAPI).then(function (response) {
        return response.json();
    }).then(function (posts) {
        console.log(posts);
    })
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
