<%--
  Created by IntelliJ IDEA.
  User: tran Hoang Phuc
  Date: 10/8/2023
  Time: 10:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FPT University Academic Portal</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="../css/student/view-attendance.css">
</head>
<body>
<jsp:include page="../root/header.jsp"></jsp:include>
<div class="header">
    <div class="choice">
        <table>
            <tr>
                <td><b>Semester</b> &nbsp; &nbsp; &nbsp;</td>
                <td style="display: flex;" id="semester"></td>
            </tr>
            <tr>
                <td><b>Course</b> &nbsp; &nbsp; &nbsp; </td>
                <td style="display: flex;" id="course">

                </td>
            </tr>

        </table>
    </div>
    <div id="student-info">
        <input type="hidden" value="${requestScope.student.sid}" readonly id="sid">
        </div>
    <div class="wrap" style="display: none;">
        <div id="absent-rate"></div>
        <table id="attendance" class="table table-striped">
            <thead>
            <tr>
                <th>No</th>
                <th>Date</th>
                <th>Slot</th>
                <th>Room</th>
                <th>Leture</th>
                <th>Group</th>
                <th>Attendance status</th>
            </tr>
            </thead>
            <tbody id="data">

            </tbody>
        </table>
    </div>
</div>
<jsp:include page="../root/footer.jsp"></jsp:include>
<script src="../js/student/view-attendance.js"></script>
</body>
</html>
