<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
    <script src="/pages/js/bootstrap.min.js"></script>
    <link href="/pages/css/bootstrap.css"  rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
</head>
<body>
<sec:authorize access="isAuthenticated()">
    <c:redirect url="/index"/>
</sec:authorize>
<div class="navbar navbar-inverse navbar-static-top">
    <nav class="navbar-inner">
        <a class="brand">Contact Book</a>
        <ul class="nav">
            <li class="divider-vertical"></li>
            <li><a href="/login">Login</a></li>
            <li><a href="/register">Register</a></li>
            <li class="dropdown pull-right">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">About <b class="caret"></b> </a>
            <ul class="dropdown-menu">
                <li><a href="/project">Project</a></li>
                <li><a href="/me"></a>Me </li>
            </ul>
            </li>
        </ul>
    </nav>
</div>
<div class="container">
    <header>
        <h1>Welcome!</h1>
    </header>
</div>
<div class="navbar-fixed-bottom row-fluid">
    <div class="navbar-inner">
        <div class="container text-center">
          @Dmitriy Smirnov 2016
        </div>
        </div>
    </div>
</body>
</html>
