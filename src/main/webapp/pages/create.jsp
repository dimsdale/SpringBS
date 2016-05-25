<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Contact</title>
    <style>
        .error { color: red; font-size: 0.9em; font-weight: bold; }
    </style>
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
            <li><a href="/index"><i class="icon-home"></i>Home </a></li>
            <li><a href="/logout">Logout</a></li>
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
<sec:authorize access="!isAuthenticated()">
    <c:redirect url="/main"/>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
<div class="container">
    <div class="row">
        <div class="well span4 offset4">

            <spring:form action="addContact" method="post" modelAttribute="contact">
                <h2>Insert data</h2>
                <spring:input path="surname" id="surname" placeholder="surname"/>
                <spring:errors path="surname" cssClass="error" />
                <spring:input path="name" id="name" placeholder="name"/>
                <spring:errors path="name" cssClass="error" />
                <spring:input path="byFatherName" id="byFatherName" placeholder="fathername"/>
                <spring:errors path="byFatherName" cssClass="error" />
                <spring:input path="mobileTel" id="mobileTel" placeholder="mobileTel"/>
                <spring:errors path="mobileTel" cssClass="error" />
                <spring:input path="homeTel" id="homeTel" placeholder="homeTel"/>
                <spring:errors path="homeTel" cssClass="error" />
                <spring:input path="e_mail" id="e_mail" placeholder="e-mail"/>
                <spring:errors path="e_mail" cssClass="error" />
                <input type="submit" id="submitContact"  value="Add" class="btn btn-success">
            </spring:form>
        </div>
        </div>
    </div>
</sec:authorize>
<div class="navbar-fixed-bottom row-fluid">
    <div class="navbar-inner">
        <div class="container text-center">
            @Dmitriy Smirnov 2016
        </div>
    </div>
</div>
</body>
</html>
