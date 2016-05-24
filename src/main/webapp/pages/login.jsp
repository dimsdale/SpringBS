<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <style>
        .well{margin-top: 240px;}
    </style>
    <title>Authorization</title>
    <script src="/pages/js/bootstrap.min.js"></script>
    <link href="/pages/css/bootstrap.css"  rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
</head>
<body>
<div class="navbar navbar-inverse navbar-static-top">
    <nav class="navbar-inner">
        <a class="brand">Contact Book</a>
        <ul class="nav">
            <li class="divider-vertical"></li>
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
<sec:authorize access="isAuthenticated()">
    <c:redirect url="/index"/>
</sec:authorize>
<sec:authorize access="!isAuthenticated()">
    <div class="container">
        <div class="row">
            <div class="well span4 offset4">
                <c:url value="/j_spring_security_check" var="loginUrl" />
                <form action="${loginUrl}" method="post" >
                    <h2 class="form-signin-heading">Input your login</h2>
                    <input type="text" class="form-control" name="j_username" placeholder="login">
                    <input type="password" class="form-control" name="j_password" placeholder="password">
                    <label class="checkbox">
                        <input type="checkbox" value="1" name="remember">
                        Remember me
                    </label>
                    <button class="btn btn-lg btn-primary btn-block" type="submit" >Login</button>
                </form>
                <c:if test="${param.error == 'invalidLoginOrPassword'}">
                    <div class="alert alert-error">
                        Login or password incorrect. Check and try again.
                    </div>
                </c:if>
            </div>
        </div>
    </div>
    <div class="form-signin" style="width: 300px;" align="center">

    </div>
</sec:authorize>
</body>
</html>