<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="../jspf/head_config.jspf"%>
</head>
<body>
<%@include file="../jspf/main_menu.jspf"%>
	<div class="container">

		<h3>Add new user:</h3>
		<form:form method="post" modelAttribute="user">
		First name: <form:input path="firstName" /><form:errors path="firstName" /><br />
		Last name: <form:input path="lastName" /><form:errors path="lastName" /><br />
		Email: <form:input path="email" /><form:errors path="email" /><br />
			<input type="submit">
		</form:form><br /> 
		${user}
	</div>
	<%@include file="../jspf/foot_config.jspf"%>
</body>
</html>