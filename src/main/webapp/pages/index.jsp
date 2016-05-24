<!--
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
-->
<!DOCTYPE html>
<html lang="en">
<head>

    <title>Contacts</title>
</head>
<body>
<sec:authorize access="!isAuthenticated()">
    <c:redirect url="/"/>
</sec:authorize>
<div class="navbar">
    <h3>Hello, ${pageContext.request.userPrincipal.name}</h3>
    <a class="btn btn-lg btn-danger" href="<c:url value="/logout" />" role="button">Logout</a>
    <a href="<c:url value="/new"/>" role="button">New Contact</a>
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