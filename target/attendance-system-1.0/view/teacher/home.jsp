<%--
  Created by IntelliJ IDEA.
  User: tran Hoang Phuc
  Date: 10/23/2023
  Time: 3:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>FPT University Academic Portal</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <style>
        .lesson{
            padding:10px 10px 0px 10px;
            border:none;
            border-radius: 10px;
            box-shadow: rgba(0, 0, 0, 0.4) 0px 0px 10px;
        }
    </style>
</head>
<body>
<input type="hidden" value="${sessionScope.user.userCode}">
<jsp:include page="../root/header.jsp"/>


<div class="row" style="margin-left: 30px;">
    <div class="col-4">
        <div class="list-group" id="list-tab" role="tablist">
            <c:forEach items="${requestScope.featureMappingUrl}" var="f">

                <a class="list-group-item list-group-item-action" id="list-profile-list" data-toggle="list"
                   href="${f.value}"
                   role="tab" aria-controls="profile">${f.key}</a>
            </c:forEach>


        </div>
    </div>
    <div class="col-8">
        <div class="tab-content" id="nav-tabContent" style="display: flex">
            <c:forEach var="l" items="${requestScope.lessons}">
                <div class="lesson">
                    <p><b>${l.groupname}</b> - <b>${l.courseName}</b></p>
                    <p><b>${l.roomName}</b></p>
                    <p>${l.timeLast}</p>
                </div>
            </c:forEach>
        </div>
    </div>
    <jsp:include page="../root/footer.jsp"/>
</body>
</html>
