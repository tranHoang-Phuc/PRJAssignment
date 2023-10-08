<%--
  Created by IntelliJ IDEA.
  User: tran Hoang Phuc
  Date: 10/8/2023
  Time: 9:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="../../css/teacher/confirm-attendance.css">
</head>
<body>
<jsp:include page="../root/header.jsp"></jsp:include>
<div class="header">
<div class="class-info">
    <p>Class: <b>SE1763</b> - <b>PRJ301</b></p>
    <p>Slot 4 - Monday 2/10/2023 with lecture <b>SonNT5</b></p>
</div>
<div class="wrap">
    <table class="table table-striped">
        <thead>
        <tr>
            <th style="color: #0e79d7;">No</th>
            <th style="color: #0e79d7;">Group</th>
            <th style="color: #0e79d7;">Code</th>
            <th style="color: #0e79d7;">Name</th>
            <th style="color: #0e79d7;">Image</th>
            <th style="color: #0e79d7;">Status</th>
            <th style="color: #0e79d7;">Comment</th>
            <th style="color: #0e79d7;">Lecture</th>
            <th style="color: #0e79d7;">Detail</th>
        </tr>
        </thead>
        <tbody id="students">
        </tbody>
    </table>
    </form>
</div>
</div>
<jsp:include page="../root/footer.jsp"/>

<script src="../../js/teacher/confirm-attandance.js"></script>
</body>
</html>
