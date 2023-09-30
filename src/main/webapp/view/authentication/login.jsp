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
        <link rel="stylesheet" href="../../css/authentication/login.css"/>
    </head>
    <body>

        <div id="login-form-wrap">
            <h2>Login</h2>
            <form id="login-form" action="#" method="POST">
                <p>
                    <input type="text" id="username" name="username" placeholder="Username" required>
                   
                </p>
                <p>
                    <input type="password" id="password" name="password" placeholder="Password" required>
                    
                </p>
                <p>
                    <input type="checkbox" name="remember" id="remember-box">
                    <label for="remeber-box">Remember me</label>
                </p>
                <p>
                    <input type="submit" id="login" value="Login">
                </p>
            </form> 
        </div>  
    </body>
</html>
