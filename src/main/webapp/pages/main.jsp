<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
</nav>
<sec:authorize access="!isAuthenticated()">
    <c:redirect url="/"/>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_ADMIN')">
    <c:redirect url="/admin"/>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_USER')">


    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <ul class="nav nav-pills nav-stacked">
                    <li class="active" ><a href="#" ><i class="fa fa-home fa-fw"></i><spring:message code="Accounts"/> </a></li>
                    <li><a href="/logout"><i class="fa fa-bar-chart-o fa-fw"></i><spring:message code="Logout"/> </a></li>
                </ul>
            </div>
            <div id="result" class="col-md-6 well">
                <c:if test="${!empty accountsList}">
                    <table data-toggle="table" class="table table h6">
                        <thead>
                        <tr>
                            <th><spring:message code="Sum"/> </th>
                            <th><spring:message code="Percentage"/> </th>
                            <th><spring:message code="Term"/> </th>
                            <th><spring:message code="Type"/> </th>
                            <th><spring:message code="DateOpen"/> </th>
                            <th><spring:message code="Status"/> </th>
                            <th><spring:message code="DateClose"/> </th>

                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${accountsList}" var="account">
                            <tr id="tr-id-1" class="tr-class-1">
                                <td>${account.sum}</td>
                                <td>${account.percentage}</td>
                                <td>${account.term_of_credit}</td>
                                <td>${account.accountType.name}</td>
                                <td><fmt:formatDate value="${account.date_of_open}" pattern="dd-MM-yyyy HH:mm:ss"/></td>
                                <td>${account.accountStatus.name}</td>
                                <td><fmt:formatDate value="${account.date_of_close}" pattern="dd-MM-yyyy HH:mm:ss"/></td>
                                <td><a href="info/${account.id}"/><spring:message code="View"/> </td>

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
