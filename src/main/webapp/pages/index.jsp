<!--
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
-->
<!DOCTYPE html>
<html lang="en">
<head>

    <title>Contacts</title>
    <script src="/pages/js/bootstrap.min.js"></script>
    <link href="/pages/css/bootstrap.css"  rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
</head>
<body>
<sec:authorize access="!isAuthenticated()">
    <c:redirect url="/"/>
</sec:authorize>
<div class="navbar navbar-inverse navbar-static-top">
    <nav class="navbar-inner">
        <a class="brand">Contact Book</a>
        <ul class="nav">
            <li class="divider-vertical"></li>
            <li><a href="/index"><i class="icon-home"></i>Home </a></li>
            <li><a href="/new">New Contact</a> </li>
            <li><a href="/logout">Logout</a></li>
            <li class="dropdown pull-right">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">About <b class="caret"></b> </a>
                <ul class="dropdown-menu">
                    <li><a href="/project">Project</a></li>
                    <li><a href="/me"></a>Me </li>
                </ul>
            </li>
        </ul>
        <form class="navbar-form pull-right" action="search" method="post">
            <input type="text" class="span2 search-query" placeholder="Input text of search" />
            <button type="submit" class="btn">Search</button>
        </form>
    </nav>
</div>
<div class="container">
    <div class="listContact" style="margin-top: 20px;">
        <sec:authorize access="isAuthenticated()">
            <c:if test="${!empty contactList}">
                <table class="data">
                    <tr>
                        <th>Name</th>
                        <th>Mobile </th>
                        <th>Home </th>
                        <th>E-mail</th>
                        <th>&nbsp;</th>
                    </tr>
                    <c:forEach items="${contactList}" var="contact">
                        <tr>
                            <td>${contact.surname}, ${contact.name}, ${contact.byFatherName}</td>
                            <td>${contact.mobileTel}</td>
                            <td>${contact.homeTel}</td>
                            <td>${contact.e_mail}</td>
                            <td><a href="delete/${contact.id}">Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>

        </sec:authorize>
    </div>

    <div class="footer">
        <p>© Dmitriy Smirnov 2016</p>
    </div>

</div>
</body>
</html>