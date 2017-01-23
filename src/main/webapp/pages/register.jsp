<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="springUtil" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>

<html>
<head>
    <script type="text/javascript" src="js/jquery-1.12.3.min.js" content="text/html; charset=ISO-8859-1" />
    <script src="/pages/js/bootstrap.min.js"></script>
    <link href="/pages/css/bootstrap.css"  rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
    <title><springUtil:message code="Register"/> </title>
</head>
<body>
<script>

</script>
<nav class = "navbar navbar-default" role = "navigation">
    <div class = "navbar-header">
        <a class = "navbar-brand"><springUtil:message code="WebBanking"/> </a>
    </div>
    <div>
        <ul class = "nav navbar-nav">
            <li><a href = "/enter"><springUtil:message code="Login"/> </a></li>
        </ul>
    </div>
</nav>
<sec:authorize access="isAuthenticated()">
    <c:redirect url="/index"/>
</sec:authorize>
<sec:authorize access="!isAuthenticated()">
    <div class="container">
        <div class="row">
            <form:form modelAttribute="user" class="form-horizontal">
                <fieldset>
                    <legend><springUtil:message code="Register"/> </legend>
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="login"><springUtil:message code="Login"/> </label>
                        <div class="col-md-4">
                            <springUtil:bind path="login">
                                <spring:input path="login" id="login" class="form-control input-md" type="text"/>
                                <spring:errors path="login" cssClass="alert alert-error" />
                            </springUtil:bind>

                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-4 control-label" for="password"><springUtil:message code="Password"/> </label>
                        <div class="col-md-4">
                            <springUtil:bind path="password">
                                <spring:input path="password" id="password" type="password" class="form-control input-md" />
                                <spring:errors path="password" cssClass="alert alert-error" />
                            </springUtil:bind>
                            <span class="help-block"> </span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="confirmPassword"><springUtil:message code="Password"/> </label>
                        <div class="col-md-4">
                            <springUtil:bind path="confirmPassword">
                                <spring:input path="confirmPassword" id="confirmPassword" type="password" class="form-control input-md" />
                                <spring:errors path="confirmPassword" cssClass="alert alert-error" />
                            </springUtil:bind>
                            <span class="help-block"> </span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="submit"> </label>
                        <div class="col-md-4">
                            <input type="submit" id="submit" class="btn btn-primary" value=<springUtil:message code="Register"/>> </input>
                        </div>
                    </div>

                </fieldset>
            </form:form>

        </div>
    </div>
</sec:authorize>
</body>
</html>
