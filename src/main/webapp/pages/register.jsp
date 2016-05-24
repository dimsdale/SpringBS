<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <script type="text/javascript" src="js/jquery-1.12.3.min.js" content="text/html; charset=ISO-8859-1" />
    <title>Registration</title>
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
<script>

</script>
<sec:authorize access="isAuthenticated()">
    <c:redirect url="/index"/>
</sec:authorize>
<sec:authorize access="!isAuthenticated()">
    <spring:form action="add" method="post" modelAttribute="user">
        <table>
            <td> <h2>Insert Data</h2></td>
           <tr>
               <td><label>Login</label></td>
               <td><spring:input path="login" id="login" placeholder="login"/></td>
               <td><spring:errors path="login" cssClass="error" /></td>
           </tr>
           <br/>
           <tr>
               <td><label>Password</label></td>
               <td><spring:input path="password" id="password" type="password"  placeholder="password"/></td>
               <td><spring:errors path="password" cssClass="error" /></td>
           </tr>
           <br/>
           <br/>
           <tr>
               <td><label>Connfirm Password</label></td>
               <td><spring:input path="confirmPassword" id="confirmPassword" type="password"  placeholder="Confirm Password"/></td>
               <td><spring:errors path="confirmPassword" cssClass="error" /></td>
           </tr>
           <br/>
           <tr>
               <td><label>Full Name</label></td>
               <td><spring:input path="fio" id="fio" placeholder="Name, surname, fathername"/></td>
               <td><spring:errors path="fio" cssClass="error" /></td>
               <br/>
           </tr>
           <br/>
            <tr>
                <td><input type="submit" id="submitUser"  value="Register"></td>
            </tr>
           </table>
    </spring:form>

</sec:authorize>
</body>
</html>
