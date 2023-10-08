<%--
  Created by IntelliJ IDEA.
  User: tran Hoang Phuc
  Date: 10/6/2023
  Time: 5:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>FPT University Academic Portal</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        footer {
            text-align: center;
            margin-top: 15px;
        }
        footer a {
            text-decoration: none;
            color: #0d6efd;
        }
        footer a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<footer>&copy; <em id="date"></em> Created by <b><a href="https://www.facebook.com/profile.php?id=100045974868894">phucthhe172242</a></b></footer>
</body>
<script>
    document.getElementById("date").innerHTML = new Date().getFullYear();
</script>
</html>
