<%--
  Created by IntelliJ IDEA.
  User: tran Hoang Phuc
  Date: 10/8/2023
  Time: 10:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>
    <title>Attendance Table</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />
    <link rel="stylesheet" href="../../css/teacher/view-attendance.css">
</head>
<body>
<jsp:include page="../root/header.jsp"></jsp:include>
<div id="header">
    <div class="choice">
        <table>
            <tr>
                <td><b>Semester</b> &nbsp; &nbsp; &nbsp;</td>
                <td style="display: flex;">
                    <button type="button"  class="element-semester">Fall2022</button>
                    <button type="button" class="element-semester">Spring2023</button>
                    <button type="button" class="element-semester">Summer2023</button>
                    <button type="button" class="element-semester">Fall2023</button>
                </td>
            </tr>
            <tr>
                <td><b>Course</b> &nbsp; &nbsp; &nbsp; </td>
                <td style="display: flex;">
                    <button type="button" class="element-course">PRJ301</button>
                    <button type="button" class="element-course">MAS292</button>
                    <button type="button" class="element-course">IoT102</button>
                    <button type="button" class="element-course">JPD123</button>
                    <button type="button" class="element-course">SWE201c</button>
                </td>
            </tr>
            <tr>
                <td><b>Class</b> &nbsp; &nbsp; &nbsp; </td>
                <td style="display: flex;">
                    <button type="button" class="element-group">SE1763</button>
                    <button type="button" class="element-group">SE1764</button>
                </td>
            </tr>
        </table>
    </div>
    <div class="wrap">
        <table border="1px">
            <thead>
            <tr>
                <th style="color: #0e79d7;">Index</th>
                <th style="color: #0e79d7;">Name</th>
                <th style="color: #0e79d7;">Code</th>
                <th style="color: #0e79d7;">Group</th>
                <th style="color: #0e79d7;">Slot 1</th>
                <th style="color: #0e79d7;">Slot 2</th>
                <th style="color: #0e79d7;">Slot 3</th>
                <th style="color: #0e79d7;">Slot 4</th>
                <th style="color: #0e79d7;">Slot 5</th>
                <th style="color: #0e79d7;">Slot 6</th>
                <th style="color: #0e79d7;">Slot 7</th>
                <th style="color: #0e79d7;">Slot 8</th>
                <th style="color: #0e79d7;">Slot 9</th>
                <th style="color: #0e79d7;">Slot 10</th>
                <th style="color: #0e79d7;">Slot 11</th>
                <th style="color: #0e79d7;">Slot 12</th>
                <th style="color: #0e79d7;">Slot 13</th>
                <th style="color: #0e79d7;">Slot 14</th>
                <th style="color: #0e79d7;">Slot 15</th>
                <th style="color: #0e79d7;">Slot 16</th>
                <th style="color: #0e79d7;">Slot 17</th>
                <th style="color: #0e79d7;">Slot 18</th>
                <th style="color: #0e79d7;">Slot 19</th>
                <th style="color: #0e79d7;">Slot 20</th>
            </tr>
            </thead>
            <tbody id="studentData">
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="../root/footer.jsp"></jsp:include>
<script src="../../js/teacher/view-attendance.js"></script>
</body>
</html>
