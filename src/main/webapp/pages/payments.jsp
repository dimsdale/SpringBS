<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><spring:message code="WebBanking"/> </title>
    <link href="/pages/css/bootstrap.css"  rel="stylesheet">
</head>
<body>
<nav class = "navbar navbar-default" role = "navigation">

    <div class = "navbar-header">
        <a class = "navbar-brand"><spring:message code="WebBanking"/> </a>
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
            <div class="col-md-3">
                <ul class="nav nav-pills nav-stacked">
                    <li><a href="/admin" ><i class="fa fa-home fa-fw"></i><spring:message code="Clients"/> </a></li>
                    <li><a href="/logout"><i class="fa fa-bar-chart-o fa-fw"></i><spring:message code="Logout"/> </a></li>
                </ul>
            </div>
            <div  class="col-md-6 well">
                <c:if test="${!empty payments}">
                    <table data-toggle="table" class="table table h6">
                        <thead>
                        <tr>
                            <th><spring:message code="DatePay"/> </th>
                            <th><spring:message code="Sum"/> </th>
                            <th><spring:message code="Type"/> </th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${payments}" var="payment">
                            <tr id="tr-id-1" class="tr-class-1">
                                <td>${payment.date_of_payment}</td>
                                <td>${payment.sum}</td>
                                <td>${payment.type.name}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:if>

            </div>
        </div>
    </div>
</sec:authorize>
<script src="/pages/js/bootstrap.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
</body>
</html>
