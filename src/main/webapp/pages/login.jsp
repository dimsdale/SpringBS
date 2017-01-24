<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="Login"/> </title>
    <script src="/pages/js/bootstrap.min.js"></script>
    <link href="/pages/css/bootstrap.css"  rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
</head>
<body>
<nav class = "navbar navbar-default" role = "navigation">
    <div class = "navbar-header">
        <a class = "navbar-brand"><spring:message code="WebBanking"/> </a>
    </div>
    <div>
        <ul class = "nav navbar-nav">
            <li><a href = "/register"><spring:message code="Register"/> </a></li>
        </ul>
    </div>
</nav>
<sec:authorize access="isAuthenticated()">
    <c:redirect url="/index"/>
</sec:authorize>
<sec:authorize access="!isAuthenticated()">
<div class="container">
    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-info" >
            <div class="panel-heading">
                <div class="panel-title"><spring:message code="Authorization"/> </div>
                <div style="float:right; font-size: 80%; position: relative; top:-10px"><a href="/restore"><spring:message code="ForgotPassword"/> </a></div>
            </div>
            <div style="padding-top:30px" class="panel-body" >
                <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
                <c:if test="${param.error == 'invalidLoginOrPassword'}">
                    <div class="alert alert-error">
                        <spring:message code="InvalidAuthorization"/>
                    </div>
                </c:if>
                <c:url value="/j_spring_security_check" var="loginUrl" />
                <form action="${loginUrl}" method="post" id="loginform" class="form-horizontal" role="form">
                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input type="text" class="form-control" name="j_username" value="" placeholder=<spring:message code="Login"/>
                    ></div>
                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input  type="password" class="form-control" name="j_password" placeholder=<spring:message code="Password"/>>
                    </div>
                    <div class="input-group">
                        <div class="checkbox">
                            <label>
                                <input id="login-remember" type="checkbox" name="remember" value="1"> <spring:message code="Remember"/>
                            </label>
                        </div>
                    </div>
                    <div style="margin-top:10px" class="form-group">
                        <div class="col-sm-12 controls">
                            <button id="btn-login" type="submit" class="btn btn-success"><spring:message code="Login"/>  </button>
                            </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</sec:authorize>
</body>
</html>