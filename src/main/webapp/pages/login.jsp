<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Authorization</title>
</head>
<body>
<sec:authorize access="isAuthenticated()">
    <c:redirect url="/index"/>
</sec:authorize>
<sec:authorize access="!isAuthenticated()">
    <div class="form-signin" style="width: 300px;" align="center">
        <c:url value="/j_spring_security_check" var="loginUrl" />
        <form action="${loginUrl}" method="post" >
            <h2 class="form-signin-heading">Введите данные</h2>
            <input type="text" class="form-control" name="j_username" placeholder="login">
            <input type="password" class="form-control" name="j_password" placeholder="password">
            <button class="btn btn-lg btn-primary btn-block" type="submit" >Login</button>
        </form>
        <p style="color: red">
            <c:if test="${param.error == 'invalidLoginOrPassword'}">
                Login or password incorrect. Check and try again.
            </c:if>
        </p>
    </div>
</sec:authorize>
</body>
</html>