const elements = document.querySelectorAll('.element-semester');
showOn(elements);
const elementCourse = document.querySelectorAll('.element-course');
showOn(elementCourse);
const elementGroup = document.querySelectorAll('.element-group');
showOn(elementGroup);


function showOn(elements) {
    elements.forEach(element => {
        element.addEventListener('click', () => {
            elements.forEach(e => e.classList.remove('selected'));
            element.classList.add('selected');
        });
    });
}

var json = `[{
   "date": "05/09/2020",
   "slot": 1,
   "room": "BE310",
   "instructor": "sonnt5",
   "group" : "SE1763",
   "attendance": "1"
}, {
   "date": "05/09/2020",
   "slot": 1,
   "room": "BE310",
   "instructor": "sonnt5",
   "group" : "SE1763",
   "attendance": "1"
}, {
   "date": "05/09/2020",
   "slot": 1,
   "room": "BE310",
   "instructor": "sonnt5",
   "group" : "SE1763",
   "attendance": "1"
}, {
   "date": "05/09/2020",
   "slot": 1,
   "room": "BE310",
   "instructor": "sonnt5",
   "group" : "SE1763",
   "attendance": "0"
}, {
   "date": "05/09/2020",
   "slot": 1,
   "room": "BE310",
   "instructor": "sonnt5",
   "group" : "SE1763",
   "attendance": "2"
}, {
   "date": "05/09/2020",
   "slot": 1,
   "room": "BE310",
   "instructor": "sonnt5",
   "group" : "SE1763",
   "attendance": "2"
}, {
   "date": "05/09/2020",
   "slot": 1,
   "room": "BE310",
   "instructor": "sonnt5",
   "group" : "SE1763",
   "attendance": "2"
}, {
   "date": "05/09/2020",
   "slot": 1,
   "room": "BE310",
   "instructor": "sonnt5",
   "group" : "SE1763",
   "attendance": "2"
}, {
   "date": "05/09/2020",
   "slot": 1,
   "room": "BE310",
   "instructor": "sonnt5",
   "group" : "SE1763",
   "attendance": "2"
}, {
   "date": "05/09/2020",
   "slot": 1,
   "room": "BE310",
   "instructor": "sonnt5",
   "group" : "SE1763",
   "attendance": "2"
}, {
   "date": "05/09/2020",
   "slot": 1,
   "room": "BE310",
   "instructor": "sonnt5",
   "group" : "SE1763",
   "attendance": "2"
}, {
   "date": "05/09/2020",
   "slot": 1,
   "room": "BE310",
   "instructor": "sonnt5",
   "group" : "SE1763",
   "attendance": "2"
}, {
   "date": "05/09/2020",
   "slot": 1,
   "room": "BE310",
   "instructor": "sonnt5",
   "group" : "SE1763",
   "attendance": "2"
}, {
   "date": "05/09/2020",
   "slot": 1,
   "room": "BE310",
   "instructor": "sonnt5",
   "group" : "SE1763",
   "attendance": "2"
}, {
   "date": "05/09/2020",
   "slot": 1,
   "room": "BE310",
   "instructor": "sonnt5",
   "group" : "SE1763",
   "attendance": "2"
},{
   "date": "05/09/2020",
   "slot": 1,
   "room": "BE310",
   "instructor": "sonnt5",
   "group" : "SE1763",
   "attendance": "2"
}, {
   "date": "05/09/2020",
   "slot": 1,
   "room": "BE310",
   "instructor": "sonnt5",
   "group" : "SE1763",
   "attendance": "2"
}, {
   "date": "05/09/2020",
   "slot": 1,
   "room": "BE310",
   "instructor": "sonnt5",
   "group" : "SE1763",
   "attendance": "2"
}, {
   "date": "05/09/2020",
   "slot": 1,
   "room": "BE310",
   "instructor": "sonnt5",
   "group" : "SE1763",
   "attendance": "2"
}, {
   "date": "05/09/2020",
   "slot": 1,
   "room": "BE310",
   "instructor": "sonnt5",
   "group" : "SE1763",
   "attendance": "2"
}]`;
var index = 1;
var tbody = document.querySelector('#data');
var data = JSON.parse(json);
data.forEach(element => {
    var date = element.date;
    var slot = element.slot;
    var room = element.room;
    var lecture = element.instructor;
    var group = element.group;
    var attendance = element.attendance;
    var color = '';
    var status = '';
    if (attendance == 0) {
        status = 'Absent';
        color = 'red';
    } else if (attendance == 1) {
        status = 'Present';
        color = 'green';
    } else {
        status = 'Future';
        color = 'orange';
    }
    tbody.innerHTML += `  <tr>
                                 <td>${index}</td>
                                 <td>${date}</td>
                                 <td>${slot}</td>
                                 <td>${room}</td>
                                 <td>${lecture}</td>
                                 <td>${group}</td>
                                 <td style="color: ${color};">${status}</td>
                              </tr>`;
    index++;
});

