<%--
  Created by IntelliJ IDEA.
  User: tran Hoang Phuc
  Date: 10/30/2023
  Time: 12:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
        <img src="${requestScope.instructor.img}" alt="">
    </div>
    <div class="info-detail">
        <table id="table">
            <tr>
                <td><b>Instructor Code:</b></td>
                <td>${requestScope.instructor.insCode}</td>
            </tr>
            <tr>
                <td><b>Full name:</b></td>
                <td>${requestScope.instructor.firstName} ${requestScope.instructor.lastName}</td>
            </tr>
            <tr>
                <td><b>Date of birth:</b></td>
                <td><fmt:formatDate type="date" value="${requestScope.instructor.dob}" /></td>
            </tr>
            <tr>
                <td><b>Phone number:</b></td>
                <td>${requestScope.instructor.phone}</td>
            </tr>
            <tr>
                <td><b>Email:</b></td>
                <td>${requestScope.instructor.email}</td>
            </tr>

        </table>
    </div>
</div>
<jsp:include page="../root/footer.jsp"/>

</body>
</html>
