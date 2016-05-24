<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
    <script src="/WEB-INF/pages/js/bootstrap.min.js"></script>
    <link href="/WEB-INF/pages/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="/WEB-INF/pages/css/bootstrap.css"  rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
</head>
<body>
<sec:authorize access="isAuthenticated()">
    <c:redirect url="/index"/>
</sec:authorize>
<div class="container">
    <header>
        <h1>Welcome!</h1>
    </header>
    <div class="navbar navbar-inverse">
        <nav class="navbar-inner">
            <ul class="nav">
                <li><a href="<c:url value="/logout" />">Logout</a></li>
                <li><a href="<c:url value="/new"/>">New Contact</a></li>
            </ul>
        </nav>
    </div>

</div>

</body>
</html>
