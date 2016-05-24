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
<div class="navbar navbar-inverse navbar-static-top">
    <nav class="navbar-inner">
        <a class="brand">Contact Book</a>
        <ul class="nav">
            <li class="divider-vertical"></li>
            <li><a href="/login">Login</a></li>
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


</sec:authorize>
</body>
</html>
