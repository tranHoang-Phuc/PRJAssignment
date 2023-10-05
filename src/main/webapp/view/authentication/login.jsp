<%-- 
    Document   : login
    Created on : Sep 30, 2023, 9:22:34 PM
    Author     : tran Hoang Phuc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FPT University Academic Portal</title>
    <link rel="stylesheet" href="css/authentication/login.css"/>

</head>
<body>
<div id="login-form-wrap">
    <h2>Sign in</h2>
    <form id="login-form" action="#" method="POST">
        <p>
            <input type="text" id="username" name="username" placeholder="Username" required>

        </p>
        <p>
            <input type="password" id="password" name="password" placeholder="Password" required>

        </p>
        <div style="color: red" id="message">${requestScope.message}</div>
        <p>
            <select name="campus" id="campus" onchange="chooseCampus()">
                <option value="0" class="campus-name" >Select campus</option>
                <c:forEach items="${requestScope.list}" var="c">
                    <option value="${c.cid}" class="campus-name">${c.cname}</option>
                </c:forEach>
            </select>

            <input type="checkbox" name="remember" id="remember-box">
            <label for="remember-box">Remember me</label>

        </p>
        <p class="button">
            <button type="submit" id="login">Sign in</button>
        </p>
    </form>
</div>
<script>
    function chooseCampus() {
        var message = document.querySelector("#message");
        message.style.display = "none";
    }
</script>
</body>
</html>
