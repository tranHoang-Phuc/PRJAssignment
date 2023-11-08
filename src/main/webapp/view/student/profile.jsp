<%--
  Created by IntelliJ IDEA.
  User: tran Hoang Phuc
  Date: 11/7/2023
  Time: 10:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/teacher/profile.css">
</head>
<body>
<jsp:include page="../root/header.jsp"/>
<div class="info-box">
    <div class="img-detail">
        <img src="${requestScope.student.img}" alt="">
    </div>
    <div class="info-detail">
        <table id="table">
            <tr>
                <td><b>Instructor Code:</b></td>
                <td>${requestScope.student.scode}</td>
            </tr>
            <tr>
                <td><b>Full name:</b></td>
                <td>${requestScope.student.firstName} ${requestScope.student.lastName}</td>
            </tr>
            <tr>
                <td><b>Date of birth:</b></td>
                <td><fmt:formatDate type="date" value="${requestScope.student.dob}" /></td>
            </tr>
            <tr>
                <td><b>Phone number:</b></td>
                <td>${requestScope.student.phone}</td>
            </tr>
            <tr>
                <td><b>Email:</b></td>
                <td>${requestScope.student.email}</td>
            </tr>

        </table>
    </div>
</div>
<jsp:include page="../root/footer.jsp"/>
</body>
</html>
