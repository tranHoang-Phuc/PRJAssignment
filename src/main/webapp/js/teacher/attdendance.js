var jsonString = '[{"group": "SE1234", "code": "HE123456", "name": "Hihi haha", "img": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRY_cb64ZNHmLWkIIOYwKdmbC3LBdGAavhLfQ&usqp=CAU", "comment": ""}, {"group": "SE1234", "code": "HE123457", "name": "Kaka haha", "img": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT6gqfc1sFuQy6tFOYOKBIy2YszMvVFMUj4ZuizdsbMFKmdMPUMOJQK10ATdRBkx1uyP98&usqp=CAU", "comment": ""}, {"group": "SE1234", "code": "HE123458", "name": "Kaka haha", "img": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT6gqfc1sFuQy6tFOYOKBIy2YszMvVFMUj4ZuizdsbMFKmdMPUMOJQK10ATdRBkx1uyP98&usqp=CAU", "comment": ""},{"group": "SE1234", "code": "HE123456", "name": "Hihi haha", "img": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRY_cb64ZNHmLWkIIOYwKdmbC3LBdGAavhLfQ&usqp=CAU", "comment": ""}, {"group": "SE1234", "code": "HE123457", "name": "Kaka haha", "img": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT6gqfc1sFuQy6tFOYOKBIy2YszMvVFMUj4ZuizdsbMFKmdMPUMOJQK10ATdRBkx1uyP98&usqp=CAU","comment": ""}, {"group": "SE1234", "code": "HE123458", "name": "Kaka haha", "img": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT6gqfc1sFuQy6tFOYOKBIy2YszMvVFMUj4ZuizdsbMFKmdMPUMOJQK10ATdRBkx1uyP98&usqp=CAU","comment": ""}]';
var classAttendance = JSON.parse(jsonString);

var students = document.querySelector('#students');
var no = 1;
classAttendance.forEach(student => {
    var group = student["group"];
    var scode = student["code"];
    var sname = student["name"];
    var img = student["img"];
    var comment = student["comment"];
    students.innerHTML += `<tr>
                                 <td>${no}</td>
                                 <td>${group}</td>
                                 <td>${scode}</td>
                                 <td>${sname}</td>
                                 <td><img src="${img}" alt=""></td>
                                 <td><input type="radio" name="status${no}" value="1" id="present${no}">
                                    <label for="present${no}">Present</label> &nbsp; &nbsp; &nbsp; 
                                    <input type="radio" name="status${no}" value="0" id="absent${no}" checked>
                                    <label for="absent${no}">Absent</label>
                                 </td>
                                 <td>${comment}</td>
                              </tr>`;
    no++;
});

function attendanceClear() {
    for (let index = 1; index < no; index++) {
        var element = `#absent${index}`;
        var check = document.querySelector(element);
        check.checked = true;
    }
}