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
    <link rel="stylesheet" href="../../css/teacher/view-attendance.css">
</head>
<body>
<jsp:include page="../root/header.jsp"></jsp:include>
<div class="header">
    <div class="choice">
        <table>
            <tr>
                <td><b>Semester</b> &nbsp; &nbsp; &nbsp;</td>
                <td style="display: flex;">
                    <button type="button" class="element-semester">Fall2022</button>
                    <button type="button" class="element-semester">Spring2023</button>
                    <button type="button" class="element-semester">Summer2023</button>
                    <button type="button" class="element-semester">Fall2023</button>
                </td>
            </tr>
            <tr>
                <td><b>Course</b> &nbsp; &nbsp; &nbsp;</td>
                <td style="display: flex;">
                    <button type="button" class="element-course">PRJ301</button>
                    <button type="button" class="element-course">MAS292</button>
                    <button type="button" class="element-course">IoT102</button>
                    <button type="button" class="element-course">JPD123</button>
                    <button type="button" class="element-course">SWE201c</button>
                </td>
            </tr>
        </table>
    </div>
    <div class="wrap">
        <table border-width="1px">
            <thead>
                <tr>
                <th>Date</th>
                <th>Slot</th>
                <th>Room</th>
                <th>Leture</th>
                <th>Group</th>
                <th>Attendance status</th>
                </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
    </div>
</div>
<jsp:include page="../root/footer.jsp"></jsp:include>
<script src="../../js/student/view-attendance.js"></script>
</body>
</html>
