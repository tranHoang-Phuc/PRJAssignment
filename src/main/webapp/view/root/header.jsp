<%-- 
    Document   : header
    Created on : Oct 2, 2023, 11:37:53 AM
    Author     : tran Hoang Phuc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0"/>
</head>
<style>
    #head-nav #logo img {
        width: 150px;
        margin-left: 80px;
    }

    .material-symbols-outlined:hover {
        opacity: 0.7;
    }

    .nav {
        margin-top: 10px;
        background-color: #f27024;
        width: 90%;
        margin-left: 50%;
        transform: translateX(-50%);
        border-radius: 7px;
        padding-top: 3px;
        opacity: 0.8;
        display: flex;
    }

    #head-nav {
        /* position: fixed; */
        top: 5px;
        right: 0;
        left: 0;
    }

    .student-info {
        width: 100%;
        position: relative;
    }

    .student-info .detail {
        position: absolute;
        right: 20px;
        top: -30px;
    }

    .detail span {
        background-color: #f58d50;
        border-bottom-left-radius: 5px;
        border-bottom-right-radius: 5px;
        position: relative;
    }

    span a {
        color: white;
        text-decoration: none;
    }

    ul {
        list-style: none;
        margin: 0px;
    }

    .dropdown {
        position: relative;
        right: -5px;
        border-bottom-left-radius: 5px;
        border-bottom-right-radius: 5px;
        display: none;
    }

    .dropdown-content {
        position: absolute;
        right: 2px;
        display: none;
        border-bottom-right-radius: 10px;
        border-bottom-left-radius: 10px;
    }
    #head-nav{
        margin-bottom: 50px;
    }
</style>
<% String homeLink = request.getContextPath() + "/home";%>
<body>
<div id="head-nav">
    <div id="logo">
        <a href="<%= homeLink%>"<%= homeLink%>"><img src="https://cdn.haitrieu.com/wp-content/uploads/2021/10/Logo-Dai-hoc-FPT.png"
                        alt="logo-đại-học-fpt"></a>
    </div>

    <div class="nav">
        <a href="<%= homeLink%>">
            <span style="color: white; margin-left: 15px;" class="material-symbols-outlined">
               home
            </span>
        </a>
        <div class="student-info">
            <div class="detail">
               <span class="material-symbols-outlined dropbtn" style="color: white;" onclick="showDrop()">
                  arrow_drop_down
               </span>
                <div style="background-color: #f58d50;" class="dropdown-content">
                    <ul>
                        <li style="display: flex; "><span style="color: white;margin-right: 5px; "
                                                          class="material-symbols-outlined ">account_circle</span>
                            <span style="color: white; margin-right: 10px;; ">${sessionScope.user.userCode}</span>
                        </li>
                        <li style="color: white; ">
                            <%String contextPath = request.getContextPath();%>
                            <a href="<%= contextPath + "/logout"%>" style="color:white; text-decoration: none; ">Log out</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    function showDrop() {
        var dropbox = document.querySelector('.dropdown-content');
        dropbox.style.display = "block ";
    }
</script>
</body>

</html>
