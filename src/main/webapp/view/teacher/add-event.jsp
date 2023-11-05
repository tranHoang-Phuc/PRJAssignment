<%--
  Created by IntelliJ IDEA.
  User: tran Hoang Phuc
  Date: 11/5/2023
  Time: 6:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>FPT University Academic Portal</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/teacher/add-event.css">
</head>
<body>
<input type="hidden" value="${requestScope.lessonId}" id="lessonId">
<jsp:include page="../root/header.jsp"></jsp:include>
<div id="event-box">
    <div id="lesson-info">

    </div>
    <form action="addEvent" method="POST">
        <div>

            <input type="hidden" value="${requestScope.lessonId}" name="lessonId">
            <textarea name="event" id="event" cols="60" rows="13"></textarea>
        </div>
        <button type="submit" id="button">ADD</button>
    </form>
</div>
<jsp:include page="../root/footer.jsp"></jsp:include>
<script src="../js/teacher/add-event.js"></script>
</body>
</html>
