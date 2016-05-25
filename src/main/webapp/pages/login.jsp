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
<div class="container">
    <div class="row">
        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#menu">
                        <span class="sr-only">Open navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <%--<a class="navbar-brand" href="#">Company</a>--%>
                </div>
                <div class="collapse navbar-collapse" id="menu">
                    <ul class="nav navbar-nav">
                        <li><a href="/register">Register</a> </li>
                        <li><a href="#">About</a> </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
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
    <div class="navbar-fixed-bottom row-fluid">
        <div class="navbar-inner">
            <div class="container text-center">
                @Dmitriy Smirnov 2016
            </div>
        </div>
    </div>
</sec:authorize>
</body>
</html>