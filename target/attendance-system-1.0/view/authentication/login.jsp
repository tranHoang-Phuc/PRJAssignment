<%-- 
    Document   : login
    Created on : Sep 30, 2023, 9:22:34 PM
    Author     : tran Hoang Phuc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <p>
                    <select name="campus" id="campus">
                        <option value="0" class="campus-name">Select campus</option>
                        <option value="1" class="campus-name">FU-Hòa Lạc</option>
                        <option value="2" class="campus-name">FU-Hồ Chí Minh</option>
                        <option value="3" class="campus-name" >FU-Đà Nẵng</option>
                        <option value="4" class="campus-name">FU-Quy Nhơn</option>
                        <option value="5" class="campus-name">FU-Cần Thơ</option>
                    </select>
                    <input type="checkbox" name="remember" id="remember-box">
                    <label for="remeber-box">Remember me</label>

                </p>
                <p class="button">
                    <button type="submit" id="login">Sign in</button>
                </p>
            </form> 
        </div>  
    </body>
</html>
