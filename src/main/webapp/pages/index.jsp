<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><spring:message code="WebBanking"/> </title>
    <link href="/pages/css/bootstrap.css"  rel="stylesheet">
</head>
<body>

<sec:authorize access="isAuthenticated()">
    <c:redirect url="/index"/>
</sec:authorize>
<nav class = "navbar navbar-default" role = "navigation">

<div class = "navbar-header">
    <a class = "navbar-brand"><spring:message code="WebBanking"/> </a>
</div>

<div>
    <ul class = "nav navbar-nav">
        <li><a href = "/enter"><spring:message code="Login"/> </a></li>
        <li><a href = "/register"><spring:message code="Register"/> </a></li>
    </ul>
</div>
</nav>
<div class="navbar-fixed-bottom row-fluid">
    <div class="navbar-inner">
        <div class="container text-center">
            <spring:message code="Welcome"/>
        </div>
    </div>
</div>
<div class="navbar-fixed-bottom row-fluid">
    <div class="navbar-inner">
        <div class="container text-center">
        </div>
    </div>
</div>
<script src="/pages/js/bootstrap.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
</body>
</html>