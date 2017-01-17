<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sspring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>

<html>
<head>
    <script type="text/javascript" src="js/jquery-1.12.3.min.js" content="text/html; charset=ISO-8859-1" />
    <script src="/pages/js/bootstrap.min.js"></script>
    <link href="/pages/css/bootstrap.css"  rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
    <title><sspring:message code="Register"/> </title>
</head>
<body>
<script>

</script>
<nav class = "navbar navbar-default" role = "navigation">
    <div class = "navbar-header">
        <a class = "navbar-brand"><sspring:message code="WebBanking"/> </a>
    </div>
    <div>
        <ul class = "nav navbar-nav">
            <li><a href = "/enter"><sspring:message code="Login"/> </a></li>
        </ul>
    </div>
</nav>
<sec:authorize access="isAuthenticated()">
    <c:redirect url="/index"/>
</sec:authorize>
<sec:authorize access="!isAuthenticated()">
    <div class="container">
        <div class="row">
            <spring:form action="add" modelAttribute="user" class="form-horizontal">
                <fieldset>
                    <legend><sspring:message code="Register"/> </legend>
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="login"><sspring:message code="Login"/> </label>
                        <div class="col-md-4">
                            <spring:input path="login" id="login" class="form-control input-md" type="text"/>
                            <spring:errors path="login" cssClass="alert alert-error" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-4 control-label" for="password"><sspring:message code="Password"/> </label>
                        <div class="col-md-4">
                            <spring:input path="password" id="password" type="password" class="form-control input-md" />
                            <spring:errors path="password" cssClass="alert alert-error" />
                            <span class="help-block"> </span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="submit"> </label>
                        <div class="col-md-4">
                            <input type="submit" id="submit" class="btn btn-primary" value=<sspring:message code="Register"/>> </input>
                        </div>
                    </div>

                </fieldset>
            </spring:form>

        </div>
    </div>
</sec:authorize>
</body>
</html>
