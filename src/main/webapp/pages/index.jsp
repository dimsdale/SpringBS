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
    <style>
        .row{margin-top: 100px;}
    </style>
</head>
<body>
<sec:authorize access="!isAuthenticated()">
    <c:redirect url="/"/>
</sec:authorize>
<div class="container">
    <div class="row">
        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle pull-right" data-toggle="collapse" data-target="#menu">
                        <span class="sr-only">Open navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand pull-left" href="#">Contact Book</a>
                </div>
                <div class="collapse navbar-collapse" id="menu">
                    <ul class="nav navbar-nav">
                        <li><a href="/">Main</a> </li>
                        <li><a href="/new">New contact</a> </li>
                        <li><a href="#">About</a> </li>
                    </ul>
                    <form class="navbar-form pull-right" action="search" method="post">
                        <input type="text" class="span2 search-query" placeholder="Input text of search" />
                        <button type="submit" class="btn">Search</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <sec:authorize access="isAuthenticated()">
            <c:if test="${!empty contactList}">
                <table class="">
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

    <div class="navbar-fixed-bottom row-fluid">
        <div class="navbar-inner">
            <div class="container text-center">
                @Dmitriy Smirnov 2016
            </div>
        </div>
    </div>
</div>
</body>
</html>