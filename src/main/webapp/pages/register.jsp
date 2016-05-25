<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <script type="text/javascript" src="js/jquery-1.12.3.min.js" content="text/html; charset=ISO-8859-1" />
    <script src="/pages/js/bootstrap.min.js"></script>
    <link href="/pages/css/bootstrap.css"  rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
    <title>Registration</title>
    <style>
        .well  {margin-top: 240px; }
        .error { color: red; font-size: 0.9em; font-weight: bold; }
    </style>
</head>
<body>
<script>

</script>
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
                        <li><a href="/login">Login</a> </li>
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
                <legend>Registration</legend>
                <spring:form action="add" method="post" modelAttribute="user" acceptCharset="UTF-8">
                            <spring:input path="login" id="login" placeholder="login" cssClass="span4"/>
                            <spring:errors path="login" cssClass="alert alert-error" />
                            <spring:input path="password" id="password" type="password"  placeholder="password"/>
                            <spring:errors path="password" cssClass="alert alert-error" />
                            <spring:input path="confirmPassword" id="confirmPassword" type="password"  placeholder="Confirm Password"/>
                            <spring:errors path="confirmPassword" cssClass="alert alert-error" />
                            <spring:input path="fio" id="fio" placeholder="Name, surname, fathername"/>
                            <spring:errors path="fio" cssClass="alert alert-error" />
                            <input type="submit" id="submitUser" value="Register" class="btn btn-block btn-success">
                       </spring:form>
            </div>
        </div>
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
