<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="springUtils" uri="http://www.springframework.org/tags" %>
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
    <title><springUtils:message code="NewPay"/> </title>
</head>
<body>
<nav class = "navbar navbar-default" role = "navigation">
    <div class = "navbar-header">
        <a class = "navbar-brand"><springUtils:message code="WebBanking"/> </a>
    </div>
    <div>
        <ul class = "nav navbar-nav">
            <li class="navbar-brand"><sec:authentication property="principal.username"/></li>
        </ul>
    </div>
</nav>
<sec:authorize access="!hasRole('ROLE_ADMIN') or !isAuthenticated()">
    <c:redirect url="/logout"/>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_ADMIN')">
    <div class="container">
        <div class="row">
            <form:form action="/admin/pay" modelAttribute="payment" class="form-horizontal">
                <fieldset>
                    <legend><springUtils:message code="NewPay"/> </legend>
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="sum"><springUtils:message code="Sum"/> </label>
                        <div class="col-md-4">
                            <form:input path="sum" id="sum" class="form-control input-md" type="text"/>
                            <form:errors path="sum" cssClass="alert alert-error" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-4 control-label" for="type"><springUtils:message code="Type"/> </label>
                        <div class="col-md-4">
                            <form:select path="type" id="type">
                                <form:option value="NONE"/>
                                <c:forEach items="${typesPayment}" var="type">
                                    <form:option value="${type}" label="${type.name}"/>
                                </c:forEach>
                            </form:select>
                            <span class="help-block"> </span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="submit"> </label>
                        <div class="col-md-4">
                            <input type="submit" id="submit" class="btn btn-primary" value=<springUtils:message code="Send"/>> </input>
                        </div>
                    </div>

                </fieldset>
            </form:form>

        </div>
    </div>
</sec:authorize>
</body>
</html>
