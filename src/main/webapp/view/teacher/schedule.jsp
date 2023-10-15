<%-- 
    Document   : schedule
    Created on : Sep 30, 2023, 10:34:25 AM
    Author     : tran Hoang Phuc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FPT University Academic Portal</title>
    <link rel="stylesheet" href="css/teacher/schedule.css"/>
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0"/>

</head>
<body>
<jsp:include page="../root/header.jsp"/>
<div class="schedule">
    <div class="query-box">
        <div id="option-box">
            <span>
            <strong style="color: red;">YEAR</strong>
         </span>
            <select name="year" id="year">
                <option value="2023">2023</option>
                <option value="2023">2022</option>
            </select><br> WEEK
            <select name="week" id="week" onchange="updateTimeTable()">
            </select>
        </div>
        <div class="search-box">
            <span><input type="text" disabled value="Hà Nội" class="campus-name"></span>
            <input type="text" name="instructor-code" id="search-bar" value="${sessionScope.user.userCode}" readonly>
        </div>
    </div>
    <table border-width="3px">
        <tr>
            <td class="day-of-week" style="background-color: #7e7fd1;color: white;">Mon</td>
            <td class="day-of-week" style="background-color: #7e7fd1;color: white;">Tue</td>
            <td class="day-of-week" style="background-color: #7e7fd1;color: white;">Wed</td>
            <td class="day-of-week" style="background-color: #7e7fd1;color: white;">Thu</td>
            <td class="day-of-week" style="background-color: #7e7fd1;color: white;">Fri</td>
            <td class="day-of-week" style="background-color: #7e7fd1;color: white;">Sat</td>
            <td class="day-of-week" style="background-color: #7e7fd1;color: white;">Sun</td>
        </tr>
        <tr class="activities">
            <td><span class="day"></span><br><br></td>
            <td><span class="day"></span><br><br></td>
            <td><span class="day"></span><br><br></td>
            <td><span class="day"></span><br><br></td>
            <td><span class="day"></span><br><br></td>
            <td><span class="day"></span><br><br></td>
            <td><span class="day"></span><br></td>
        </tr>
        <tr id="slot1" class="slot">
            <td class="mon">-</td>
            <td class="tue">-</td>
            <td class="wed">-</td>
            <td class="thu">-</td>
            <td class="fri">-</td>
            <td class="sat">-</td>
            <td class="sun">-</td>
        </tr>

        <tr id="slot2" class="slot">
            <td class="mon">-</td>
            <td class="tue">-</td>
            <td class="wed">-</td>
            <td class="thu">-</td>
            <td class="fri">-</td>
            <td class="sat">-</td>
            <td class="sun">-</td>
        </tr>
        <tr id="slot3" class="slot">
            <td class="mon">-</td>
            <td class="tue">-</td>
            <td class="wed">-</td>
            <td class="thu">-</td>
            <td class="fri">-</td>
            <td class="sat">-</td>
            <td class="sun">-</td>
        </tr>
        <tr id="slot4" class="slot">
            <td class="mon">-</td>
            <td class="tue">-</td>
            <td class="wed">-</td>
            <td class="thu">-</td>
            <td class="fri">-</td>
            <td class="sat">-</td>
            <td class="sun">-</td>
        </tr>
        <tr id="slot5" class="slot">
            <td class="mon">-</td>
            <td class="tue">-</td>
            <td class="wed">-</td>
            <td class="thu">-</td>
            <td class="fri">-</td>
            <td class="sat">-</td>
            <td class="sun">-</td>
        </tr>&nbsp;
        <tr id="slot6" class="slot">
            <td class="mon">-</td>
            <td class="tue">-</td>
            <td class="wed">-</td>
            <td class="thu">-</td>
            <td class="fri">-</td>
            <td class="sat">-</td>
            <td class="sun">-</td>
        </tr>&nbsp;
    </table>
</div>
<script src="js/teacher/schedule.js"></script>
<jsp:include page="../root/footer.jsp"/>
</body>
</html>
