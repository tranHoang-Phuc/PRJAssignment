var lessonId = document.querySelector('#lessonId');
var url = 'http://localhost:8080/attendance_system_war/api/teacher/report/attendance/' + lessonId.value;
var students = document.querySelector('#students');
var no = 1;
fetch(url)
    .then(response => response.json())
    .then(data => {
        data.forEach(dat => {
            var sid = dat["student"]["sid"];
            var group = dat["lesson"]["groupname"];
            var scode = dat["student"]["scode"];
            var sname = dat["student"]["firstName"] + " " + dat["student"]["lastName"];
            var img = dat["student"]["img"];
            var status = dat["status"];
            var comment = dat["comment"] === null ? "" : dat["comment"];
            students.innerHTML += `<tr>
                                 <td>${no}</td>
                                 <input type="hidden" value="${no}" name="index">
                                 <input type="hidden" value="${sid}" name="sid${no}">
                                 <td>${group}</td>
                                 <td>${scode}</td>
                                 <td>${sname}</td>
                                 <td><img src="${img}" alt=""></td>
                                 <td><input type="radio" name="status${no}" value="1" id="present${no}" ${status==1?"checked":""}>
                                    <label for="present${no}">Present</label> &nbsp; &nbsp; &nbsp; 
                                    <input type="radio" name="status${no}" value="0" id="absent${no}" ${status!=1?"checked":""}>
                                    <label for="absent${no}">Absent</label>
                                 </td>
                                 <td><textarea name="comment${no}"  cols="30" rows="4" >${comment}</textarea></td>
                              </tr>`;
            no++;
        });
    });



function attendanceClear() {
    for (let index = 1; index < no; index++) {
        var element = `#absent${index}`;
        var check = document.querySelector(element);
        check.checked = true;
    }
}