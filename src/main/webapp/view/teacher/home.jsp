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
</head>
<body>
<jsp:include page="../root/header.jsp"/>
<c:forEach items="${requestScope.featureMappingUrl}" var="f">
    <ul>
        <li><a href="${f.value}">${f.key}</a></li>
    </ul>
</c:forEach>

<jsp:include page="../root/footer.jsp"/>
</body>
</html>
