<%-- 
    Document   : header
    Created on : Oct 2, 2023, 11:37:53 AM
    Author     : tran Hoang Phuc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FPT University Academic Portal</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
        <style>
            #header {
                width: 90%;
                margin-left: 50%;
                transform: translateX(-50%);
                margin-bottom: 50px

            }
            .nav {
                padding: 7px 5px;
                border-radius: 3px;
                border: none;
                background-color: #f5f5f5;
            }
            a {
                margin-left: 15px;
                color: blue;
                text-decoration: none;
            }
            a:hover {
                opacity: 0.9;
                text-decoration: underline;
            }
            #title {
                height: 100px;
                justify-content: center;
            }

            #title span {
                line-height: 100px
            }
        </style>
    </head>
    <body>
        <div id="header">
            <div id="title">
                <h1>
                    <span>FPT University Academic Portal</span>
                </h1>
            </div>
            <div class="nav">
                <a href="#">Home</a> &nbsp;|&nbsp; <b>${requestScope.title}</b>
                <!-- Dùng servlet để trả về thẻ b-->
            </div>
        </div>
    </body>
</html>
