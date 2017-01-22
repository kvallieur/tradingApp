<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- let's add tag srping:url -->
<spring:url value="/resources/css/login.css" var="loginCSS" />
<spring:url value="/resources/js/login.js" var="loginJS" />
<link href="${loginCSS}" rel="stylesheet" />
<script src="${loginJS}"></script>
<!-- Finish adding tags -->
<title>Trading-App: Login</title>

</head>
<body>
     <h4>User Login.</h4>
     <form:form method="post" name="loginForm" action = "authenticate.html">
         <table>
             <tr><td>User Name: </td><td><input name="userName" type="text"></td></tr>
             <tr><td>Password: </td><td><input name="password" type="password"></td></tr>
             <tr><td colspan="2" align="right"><input type="submit" value="Submit"></td></tr>
         </table>
         <div style="color:red">${error}</div>
     </form:form>

</body>
</html>
