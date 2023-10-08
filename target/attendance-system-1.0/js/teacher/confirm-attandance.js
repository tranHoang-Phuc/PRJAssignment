
    var jsonString = `[
    {"group": "SE1234",
        "code": "HE123456",
        "name": "Hihi haha",
        "img": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRY_cb64ZNHmLWkIIOYwKdmbC3LBdGAavhLfQ&usqp=CAU",
        "attendanceStatus": "1",
        "comment" :"",
        "lecture" :"sonnt5"},
    {"group": "SE1234",
        "code": "HE123457",
        "name": "Kaka haha",
        "img": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT6gqfc1sFuQy6tFOYOKBIy2YszMvVFMUj4ZuizdsbMFKmdMPUMOJQK10ATdRBkx1uyP98&usqp=CAU",
        "attendanceStatus": "0",
        "comment" :"",
        "lecture" :"sonnt5"},
    {"group": "SE1234",
        "code": "HE123458",
        "name": "Kaka haha",
        "img": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT6gqfc1sFuQy6tFOYOKBIy2YszMvVFMUj4ZuizdsbMFKmdMPUMOJQK10ATdRBkx1uyP98&usqp=CAU",
        "attendanceStatus": "1",
        "comment" :"",
        "lecture" :"sonnt5"},
    {"group": "SE1234",
        "code": "HE123456",
        "name": "Hihi haha",
        "img": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRY_cb64ZNHmLWkIIOYwKdmbC3LBdGAavhLfQ&usqp=CAU",
        "attendanceStatus": "1",
        "comment" :"",
        "lecture" :"sonnt5"},
    {"group": "SE1234",
        "code": "HE123457",
        "name": "Kaka haha",
        "img": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT6gqfc1sFuQy6tFOYOKBIy2YszMvVFMUj4ZuizdsbMFKmdMPUMOJQK10ATdRBkx1uyP98&usqp=CAU",
        "attendanceStatus": "0",
        "comment" :"",
        "lecture" :"sonnt5"},
    {"group": "SE1234",
        "code": "HE123458",
        "name": "Kaka haha",
        "img": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT6gqfc1sFuQy6tFOYOKBIy2YszMvVFMUj4ZuizdsbMFKmdMPUMOJQK10ATdRBkx1uyP98&usqp=CAU",
        "attendanceStatus": "0",
        "comment" :"",
        "lecture" :"sonnt5"}]`;
    var classAttendance = JSON.parse(jsonString);
    var students = document.querySelector('#students');
    var no = 1;
    classAttendance.forEach(student => {
    var group = student["group"];
    var scode = student["code"];
    var sname = student["name"];
    var img = student["img"];
    var status = student["attendanceStatus"];
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
    var comment = student["comment"];
    var lecture = student["lecture"];
    students.innerHTML += `<tr>
                                       <td>${no}</td>
                                       <td>${group}</td>
                                       <td>${scode}</td>
                                       <td>${sname}</td>
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
                                          <input type="hidden" value="PRJ301">
                                       <td><span><button type="button" class="btn btn-outline-primary" onclick="attendanceClear()">View detail</button></span></td>
                                       </form>
                                 </tr>`;
    no++;
});
