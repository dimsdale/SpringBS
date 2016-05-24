<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Contact</title>
    <style>
        body { background-color: #eee; font: helvetica; }
        #container { width: 500px; background-color: #fff;
            margin: 30px auto; padding: 30px; border-radius: 5px; }
        .green { font-weight: bold; color: green; }
        label {width:70px; display:inline-block;}
        input { display:inline-block; margin-right: 10px; }
        form {line-height: 160%; }
        .hide { display: none; }
        .error { color: red; font-size: 0.9em; font-weight: bold; }
    </style>
</head>
<body>
<sec:authorize access="!isAuthenticated()">
    <c:redirect url="/main"/>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <spring:form action="addContact" method="post" modelAttribute="contact">
        <h2>Insert data</h2>
        <label>Surname: </label>
        <spring:input path="surname" id="surname" placeholder="surname"/>
        <spring:errors path="surname" cssClass="error" />
        <br/>
        <label>Name: </label>
        <spring:input path="name" id="name" placeholder="name"/>
        <spring:errors path="name" cssClass="error" />
        <br/>
        <label>FatherName: </label>
        <spring:input path="byFatherName" id="byFatherName" placeholder="fathername"/>
        <spring:errors path="byFatherName" cssClass="error" />
        <br/>
        <label>Mobile: </label>
        <spring:input path="mobileTel" id="mobileTel" placeholder="mobileTel"/>
        <spring:errors path="mobileTel" cssClass="error" />
        <br/>
        <label>Home Tel: </label>
        <spring:input path="homeTel" id="homeTel" placeholder="homeTel"/>
        <spring:errors path="homeTel" cssClass="error" />
        <br/>
        <label>E-mail: </label>
        <spring:input path="e_mail" id="e_mail" placeholder="e-mail"/>
        <spring:errors path="e_mail" cssClass="error" />
        <br/>

        <br/>
        <input type="submit" id="submitContact"  value="Add">
    </spring:form>
</sec:authorize>
</body>
</html>
